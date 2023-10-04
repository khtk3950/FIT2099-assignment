package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.enums.Status;

/**
 * Ally
 */
public class Ally extends Summoned{
    /**
     * Constructor
     * @param name name of the ally
     * @param displayChar Char that represent the ally
     * @param hitPoints hit point of the ally
     */
    public Ally(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
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

        if (otherActor.hasCapability(Status.DEAD)) {
            actions.add(new DoNothingAction());
        }

        if(!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            this.behaviours.put(1, new AttackBehaviour(otherActor,direction));
        }

        return actions;
    }

    /**
     * tostring method
     * @return "Ally"
     */
    public String toString(){
        return "Ally";
    }
}
