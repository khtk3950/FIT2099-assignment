package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.behaviours.*;
import game.managers.ResetManager;
import game.managers.Resettable;
import game.enums.Species;
import game.enums.Status;

import java.util.Map;
import java.util.TreeMap;
/**
 * Class representing the Enemy. It implements the Resettable interface.
 * It gives all the hostile creature common behaviours
 * Created by:
 * @author Goy
 * Modified by:
 *
 */
public abstract class Enemy extends Actor implements Resettable {
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();
    protected Species species;

    /**
     * Constructor.
     *
     * @param name        the name of the Enemy
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Enemy's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints, Species species) {
        super(name, displayChar, hitPoints);
        this.species=species;
        this.addCapability(species);
        this.behaviours.put(3, new DespawnBehaviour());
        this.behaviours.put(999, new WanderBehaviour());
        ResetManager.getResetManager().registerResettable(this);
    }
    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (this.hasCapability(Status.WIPED)){
            return new DespawnAction(this, map);
        }
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.DEAD)){
            actions.add(new DoNothingAction());
        }

        /**
         * Will only be checked when the player is around
         */
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            //normal attack with intrinsic weapon
            actions.add(new AttackAction(this, direction));
            //create a for each loop here to loop thru player's inventory list
            for(Weapon weapon : otherActor.getWeaponInventory()) {
                //normal attack with weapon
                actions.add(new AttackAction(this,direction,weapon));
                //attack with weapon skill
                actions.add(weapon.getSkill(this,direction));
            }
            this.behaviours.put(1, new FollowBehaviour(otherActor));
            this.behaviours.put(2, new AttackBehaviour(otherActor,direction));

        }

        if (!otherActor.hasCapability(this.species)&&!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            this.behaviours.put(4, new AttackBehaviour(otherActor,direction));
        }
        return actions;
    }


    @Override
    public void reset() {
        this.addCapability(Status.WIPED);
    }
}
