package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.enums.Species;

/**
 * abstract class for enemy factory
 */
public abstract class EnemyFactory {
    /**
     * spawn enemy
     * @param location location to spawn
     * @param species species of enemy
     */
    public abstract void spawnEnemies(Location location , Species species);

}
