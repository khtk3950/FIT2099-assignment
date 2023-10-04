package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.actions.TeleportAction;
import game.enums.Species;

/**
 * golden fog door. It allows the player to travel to other parts of Limgrave.
 */
public class GoldenFogDoor extends Ground {
    private Location destinationDoor;
    private String destination;
    /**
     * Constructor
     */
    public GoldenFogDoor(Location destinationDoor, String destination) {
        super('D');
        this.destinationDoor = destinationDoor;
        this.destination = destination;
    }
    /**
     * only player can enter here
     * @param actor the Actor to check
     * @return if the actor can enter
     */
    public boolean canActorEnter(Actor actor) {
        boolean flag = false;
        if(actor.hasCapability(Species.PLAYER)){
            flag=true;
        }
        return flag;
    }

    /**
     * allowable action that player can do to the ground
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return the action that player can do to the ground
     */
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        actions.add(new TeleportAction(actor, destinationDoor, destination));
        return actions;
    }

}
