package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Species;
import game.enums.Status;
import game.utils.RandomNumberGenerator;

/**
 * PuddleOfWater
 */
public class PuddleOfWater extends Ground {
    /**
     * enemy factory that spawn enemy
     */
    private EnemyFactory enemyFactory;
    /**
     * Constructor
     */
    public PuddleOfWater() {
        super('~');
    }
    /**
     * set the enemy factory base of the ground is at east side or west side of the map
     * @param status indicate the ground is at west side or east side of the map
     */
    public void setEnemyFactory(Status status){
        if(status==Status.WEST)
            this.enemyFactory= new WestMapEnemyFactory();
        else{
            this.enemyFactory= new EastMapEnemyFactory();
        }
    }
    /**
     * tick method, it will spawn enemy according to  if it is at west side or east side of the map,
     * change of spawning, species of actor enemy that the ground will spawn
     * @param location The location of the Ground
     */
    public void tick(Location location){
        if(location.x()<=(location.map().getXRange().max()/2)){
            setEnemyFactory(Status.WEST);
        }
        else{
            setEnemyFactory(Status.EAST);
        }
        if (RandomNumberGenerator.getRandomInt(0, 100) <= 27) {
            if (!location.map().isAnActorAt(location))
                enemyFactory.spawnEnemies(location, Species.WATER);
        }
    }

}

