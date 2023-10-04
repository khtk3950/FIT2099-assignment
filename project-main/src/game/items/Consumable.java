package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface for consumable
 */
public interface Consumable {
    /***
     * consume the item
     * @param consumer consumer actor
     */
    public void consumeItem(Actor consumer);

    /**
     *get the number of use
     */
    public int getNumOfUses();

    /**
     *get the max number of use
     */
    public int getMaxUses();

    /**
     *print uses
     */
    public String printUses();
}
