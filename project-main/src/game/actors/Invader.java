package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.enums.Status;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * Invader
 */
public class Invader extends Summoned{
    /**
     * Constructor
     * @param name name of the invader
     * @param displayChar Char that represent the invader
     * @param hitPoints hit point of the invader
     */
    public Invader(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.ENEMY);
        RunesManager.getRunesManager().setActorRune(this, new Runes("Invader Runes", RandomNumberGenerator.getRandomInt(1358, 5578), false));
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
        /**
         * For player & Ally
         */
        if (otherActor.hasCapability(Status.DEAD)){
            actions.add(new DoNothingAction());
        }
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            //create a for each loop here to loop thru PLayer's inventory list
            for(Weapon weapon : otherActor.getWeaponInventory()) {
                //normal attack with weapon
                actions.add(new AttackAction(this,direction,weapon));
                //attack with weapon skill
                actions.add(weapon.getSkill(this,direction));
            }
            this.behaviours.put(1, new FollowBehaviour(otherActor));
            this.behaviours.put(2, new AttackBehaviour(otherActor,direction));
        }

        if (!otherActor.hasCapability(Status.ENEMY)&&!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            this.behaviours.put(1, new AttackBehaviour(otherActor,direction));
        }
        return actions;
    }

    /**
     * to string method
     * @return a string represent the actor
     */
    public String toString(){
        return "Invader";
    }
}
