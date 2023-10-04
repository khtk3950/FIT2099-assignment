package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.DespawnAction;
import game.actors.roles.*;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.enums.Status;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
/**
 * Class representing the Summoned actor from the Summon ground. It extends the Actor abstract class
 * It gives all the common behaviour of a Summoned character and giving Summoned character a random Role.
 * Created by:
 * @author Goy
 * Modified by:
 *
 */
public abstract class Summoned extends Actor {
    /**
     * role of the actor
     */
    private Roles role;
    /**
     * random value
     */
    private final Random random = new Random();
    /**
     * behaviour of the actor
     */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor.
     *
     * @param name        Name to call the Summoned actor in the UI
     * @param displayChar Character to represent the Summoned actor in the UI
     * @param hitPoints   Summoned actor's starting number of hitpoints
     */
    public Summoned(String name, char displayChar, int hitPoints){
        super(name, displayChar, hitPoints);
        this.role=setRole();
        this.hitPoints=role.getStartingHitPoint();
        this.addWeaponToInventory(role.getStartingWeapon());
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Role setter
     *This setter will randomly assign a role to the actor summoned
     * @return a role
     */
    public Roles setRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new Astrologer());
        roles.add(new Bandit());
        roles.add(new Wretch());
        roles.add(new Samurai());
        return roles.get(random.nextInt(roles.size()));
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
    @Override
    public Action playTurn (ActionList actions, Action lastAction, GameMap map, Display display){
        if (this.hasCapability(Status.WIPED)) {
            return new DespawnAction(this, map);
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

}
