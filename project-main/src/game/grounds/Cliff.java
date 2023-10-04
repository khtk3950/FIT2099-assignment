package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.DeathActions;
import game.enums.Species;

/**
 * Cliff! beware!
 */
public class Cliff extends Ground {
    /**
     * Constructor
     */
    public Cliff() {
        super('+');
    }

    /**
     * only player can enter here
     * @param actor the Actor to check
     * @return if the actor can enter
     */

    public boolean canActorEnter(Actor actor) {
        boolean flag = false;
        if (actor.hasCapability(Species.PLAYER)) {
            flag = true;
        }
        return flag;
    }

    /**
     * tick method,if the actor enter here it will die
     * @param location The location of the Ground
     */
    public void tick(Location location) {
        if (location.containsAnActor()) {
            new DeathActions(location.getActor()).execute(location.getActor(), location.map());
        }
    }
}

