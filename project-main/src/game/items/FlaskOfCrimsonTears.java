package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeItemAction;
import game.managers.ResetManager;
import game.managers.Resettable;

/**
 * Flask Of Crimson Tears
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {
    /**
     * max number of use
     */
    private final int maxUses = 2;
    /**
     * current number of use
     */
    private int numOfUses;

    /**
     * Constructor
     * @param name name of the FlaskOfCrimsonTears
     * @param displayChar char to display it
     */
    public FlaskOfCrimsonTears(String name, char displayChar){
        super(name, displayChar, false);
        this.numOfUses = maxUses;
        this.addAction(new ConsumeItemAction(this));
        ResetManager.getResetManager().registerResettable(this);
    }

    /**
     * after consume  the consumer's health will be restored by 250 points
     * @param consumer consumer actor
     */
    public void consumeItem(Actor consumer){
        consumer.heal(250);
        this.useFlask();
    }

    /**
     *get the number of use
     * @return number of use
     */
    public int getNumOfUses(){
        return numOfUses;
    }

    /**
     *get the max number of use
     * @return the max number of use
     */
    public int getMaxUses(){return maxUses;}

    /**
     *decrease the number of use by 1
     */
    public void useFlask(){
        numOfUses -= 1;
    }

    /**
     *reset the current number of use to max number of use
     */
    public void reset(){
        numOfUses = maxUses;
    }

    /**
     * it will return the current number of use and max number of use
     * @return the current number of use and max number of use
     */
    public String printUses(){return "(" + numOfUses + "/" + maxUses + ")";}
}
