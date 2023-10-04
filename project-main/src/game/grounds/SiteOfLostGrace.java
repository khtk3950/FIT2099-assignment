package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.enums.Status;

/**
 * Site Of Lost Grace, player can reset the map here
 */

public class SiteOfLostGrace extends Ground {
    /**
     *  name of the site of lost grace
     */
    String name;

    /**
     * Constructor
     * @param name name of the site of lost grace
     */
    public SiteOfLostGrace(String name){
        super('U');
        this.name = name;
    }
    /**
     * only actor that have HOSTILE_TO_ENEMY status can enter here
     * @param actor the Actor to check
     * @return if the actor can enter
     */
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
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
        actions.add(new RestAction(this));
        return actions;
    }

    /**
     * to string method
     * @return the name of the site of lost grace
     */
    public String toString(){
        return this.name;
    }

    public void tick (Location location ){

    }
}

