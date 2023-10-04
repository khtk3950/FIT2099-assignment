package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.Dogs;
import game.actors.GodrickSoldiers;
import game.actors.West.GiantCrab;
import game.actors.West.HeavySkeletalSwordsman;
import game.actors.West.LoneWolf;
import game.enums.Species;

/**
 * enemy factory for west side of the map
 */
public class WestMapEnemyFactory extends EnemyFactory{
    /**
     * Spawn enemy for west side of the map
     * @param location location to spawn
     * @param species species of enemy
     */
    @Override
    public void spawnEnemies(Location location, Species species) {
        if(species==Species.SKELETAL){
            location.addActor(new HeavySkeletalSwordsman());
        }

        if(species==Species.LAND){
            location.addActor(new LoneWolf());
        }

        if(species==Species.WATER){
            location.addActor(new GiantCrab());
        }

        if(species==Species.DOG){
            location.addActor(new Dogs());
        }

        if(species==Species.GODRICK){
            location.addActor(new GodrickSoldiers());
        }
    }
}
