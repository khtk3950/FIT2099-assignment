package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.West.HeavySkeletalSwordsman;
import game.actors.East.SkeletalBandit;
import game.enums.Species;

/**
 *An action that revive piles of bones
 */
public class ReviveAction extends Action {
    /**
     *The actor that will be revive
     */
    private Actor actor;
    /**
     *The map that the actor is on
     */
    private GameMap map;
    /**
     *The location of the actor
     */
    private Location temp;
    /**
     *The species of the actor
     */
    private Species variant;

    /**
     * Constructor
     * @param actor
     * @param map
     * @param variant
     */
    public ReviveAction(Actor actor, GameMap map, Species variant) {
        this.actor = actor;
        this.map = map;
        this.variant=variant;
    }

    /**
     * When executed, it will remove the actor(piles of bone) from map and spawn the actor that the
     * species of the actor(pile of bones) belongs to.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return "Piles of bones successfully revived"
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        temp = map.locationOf(actor);
        map.removeActor(actor);
        if (variant==Species.SWORDSMAN) {

            map.addActor(new HeavySkeletalSwordsman(), temp);

        } else {
            map.addActor(new SkeletalBandit(), temp);
        }
        return "Piles of bones successfully revived";
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
