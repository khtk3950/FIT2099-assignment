package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeItemAction;
import game.enums.Status;
import game.managers.ResetManager;
import game.managers.Resettable;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

public class GoldenRunes extends Item implements Consumable{
    /**
     *max number of use
     */
    private final int maxUses = 1;
    /**
     * current number of use
     */
    private int numOfUses = 1;
    /**
     *amount of runes generated after being consumed
     */
    int value;

    /**
     * Constructor
     */
    public GoldenRunes(){
        super("Golden Runes", '*', true);
        this.value = RandomNumberGenerator.getRandomInt(200, 10000);
    }

    /**
     * tick method
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */

    public void tick(Location currentLocation, Actor actor) {
        if(this.getAllowableActions().isEmpty()){
            this.addAction(new ConsumeItemAction(this));
        }
    }

    /**
     * second tick method that removes the ConsumeItemAction of Golden Runes.
     * Prevents Player from being able to consume the golden runes after dropping it.
     * @param currentLocation The location of the ground on which we lie.
     */
    public void tick(Location currentLocation){
        // Checks if Player has picked up the Golden Runes before.
        // If Player has picked it up before, its action list will not be empty.
        if(!this.getAllowableActions().isEmpty()){
            this.removeAction(this.getAllowableActions().get(0));
        }
    }

    /**
     *consume the item, it will add random amount of runes(between 200 to 10000 to the consumer and remove
     * it from the consumer inventory.
     * @param consumer
     */
    @Override
    public void consumeItem(Actor consumer) {
        RunesManager.getRunesManager().addRunes(consumer, value);
        consumer.removeItemFromInventory(this);
        numOfUses -= 1;
    }

    /**
     *get the number of use
     * @return number of use
     */

    @Override
    public int getNumOfUses() {
        return numOfUses;
    }

    /**
     *get the max number of use
     * @return the max number of use
     */
    @Override
    public int getMaxUses() {
        return maxUses;
    }

    /**
     * it will return the current number of use and max number of use
     * @return the current number of use and max number of use
     */
    @Override
    public String printUses() {
        return "(" + numOfUses + "/" + maxUses + ")";
    }


}

