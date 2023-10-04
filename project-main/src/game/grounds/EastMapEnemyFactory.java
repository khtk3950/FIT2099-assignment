package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.Dogs;
import game.actors.East.GiantCrayFish;
import game.actors.East.GiantDog;
import game.actors.East.SkeletalBandit;
import game.actors.GodrickSoldiers;
import game.enums.Species;

/**
 * enemy factory for east side of the map
 */
public class EastMapEnemyFactory extends EnemyFactory{
    /**
     * spawn enemy for east side of the map
     * @param location location to spawn
     * @param species species of enemy
     */
    @Override
    public void spawnEnemies(Location location, Species species) {
        if(species==Species.SKELETAL){
            location.addActor(new SkeletalBandit());
        }

        if(species==Species.LAND){
            location.addActor(new GiantDog());
        }

        if(species==Species.WATER){
            location.addActor(new GiantCrayFish());
        }

        if(species==Species.DOG){
            location.addActor(new Dogs());
        }

        if(species==Species.GODRICK){
            location.addActor(new GodrickSoldiers());
        }

    }
}
