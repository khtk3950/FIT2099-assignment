package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An action to teleport the actor
 */
public class TeleportAction extends Action {
    /**
     * The actor that will be teleported
     */
    private Actor player;
    /**
     * The destinationdoor
     */
    private Location destinationDoor;
    /**
     * The name of destination
     */
    private String destination;

    /**
     * Constructor
     * @param player The actor that will be teleported
     * @param destinationDoor The destinationdoor
     * @param destination The name of destination
     */
    public TeleportAction(Actor player , Location destinationDoor, String destination){
        this.player=player;
        this.destinationDoor=destinationDoor;
        this.destination = destination;
    }

    /**
     *When executed it will remove the actor from map and add the actor to the location of the
     * destination door.
     * @param player The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    public String execute(Actor player, GameMap map) {
        map.removeActor(player);
        destinationDoor.map().addActor(player, destinationDoor);
        return player + " teleported to "+ destination;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return player + " teleports to " + destination;
    }
}
