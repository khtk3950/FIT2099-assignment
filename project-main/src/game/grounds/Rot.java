package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * lake of rot, it will damage player over time
 */
public class Rot extends Ground {
    /**
     * Constructor
     */
    public Rot() {
        super('^');
    }

    /**
     * tick method, it will damage player over time.
     * @param location The location of the Ground
     */
    public void tick (Location location ){
        if(location.containsAnActor()){
            location.getActor().hurt(10);
        }
    }
}
