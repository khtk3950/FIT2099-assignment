package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Species;

/**
 * An action that despawn an actor
 */

public class DespawnAction extends Action {
    /**
     * The actor that will be despawned
     */
        private Actor actor;
    /**
     * The map the actor is in
     */
    private GameMap map;

    /**
     * Constructor.
     * @param actor The actor that will be despawned
     * @param map The map the actor is in
     */
        public DespawnAction(Actor actor , GameMap map){
            this.actor=actor;
            this.map=map;
        }

    /**
     * When executed it will first check if the actor is consious or not, if it is conscious, it will
     * despawn remove it from map.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the despwan
     */

        @Override
        public String execute(Actor actor, GameMap map) {
            if(!actor.isConscious()){
                return null;
            }
            map.removeActor(actor);
            return actor + " is removed from the map";
        }

    /**
     *
     * @param actor The actor performing the action.
     * @return null
     */

    @Override
        public String menuDescription(Actor actor) {
            return null;
        }
    }

