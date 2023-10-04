package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.RandomNumberGenerator;
import game.actions.DespawnAction;

/**
 * A class that figures out a despawn action that will despawn the actor
 */
public class DespawnBehaviour implements Behaviour {
    /**
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if(RandomNumberGenerator.getRandomInt(0,10)<=1)
            return new DespawnAction(actor,map);
        return null;
    }
}
