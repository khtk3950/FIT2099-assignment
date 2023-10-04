package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

/**
 * An action the performs the skill quickstep
 */
public class QuickstepAction extends Action {
    /**
     * The Actor that is to be attacked
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;




    /**
     * Constructor with skill attack from the weapon
     *
     * @param target the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public QuickstepAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;


    }




    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     * After that move the actor to a random exit.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see NormalDeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + "."+QuickStepMove(actor,map);
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        result+= QuickStepMove(actor,map);
        if (!target.isConscious()) {
            result += new DeathActions(actor).execute(target, map);
        }
        return result;
    }

    /**
     * When executed it will move actor to a random exit
     * @param actor actor been move
     * @param map the map the actor is in
     * @return the result of the player being move.
     */
    private String QuickStepMove(Actor actor, GameMap map) {
        ArrayList<Exit> exits = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                exits.add(exit);
            }
        }
        Location destination = exits.get(rand.nextInt(exits.size())).getDestination();
        String result = "\n" + actor + " moves to " + "(" + destination.x() + "," + destination.y() + ")";
        map.moveActor(actor, destination);
        return result;

    }

    /**
     * Describes which target the actor is attacking and the actor moves away.
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor +  " attacks " + target +" and moves away"  ;
    }
}
