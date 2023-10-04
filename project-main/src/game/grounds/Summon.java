package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;
import game.enums.Species;
import game.enums.Status;
import game.utils.RandomNumberGenerator;

/**
 * summon, it allows player to summon invader/ally
 */
public class Summon extends Ground {
    private EnemyFactory enemyFactory;
    /**
     * Constructor
     */
    public Summon() {
        super('=');
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
        actions.add(new SummonAction(location));
        return actions;
    }
    /**
     * only player can enter here
     * @param actor the Actor to check
     * @return if the actor can actor
     */
    public boolean canActorEnter(Actor actor) {
        boolean flag = false;
        if(actor.hasCapability(Species.PLAYER)){
            flag=true;
        }
        return flag;
    }
}
