package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RetrieveRunesAction;
import game.enums.Status;

import java.util.List;

/**
 * rune item
 */
public class Runes extends Item{
    /**
     * value of rune
     */
    int value;

    /**
     * Constructor
     * @param name name of the rune
     * @param value value of the rune
     * @param portable is it portable?
     */
    public Runes(String name, int value, boolean portable){
        super(name, '$', portable);
        this.value = value;
        // Register as resettable in deathaction
    }

    /**
     * get the value of the rune
     * @return value of the rune
     */
    public int getValue(){
        return this.value;
    }

    /**
     * add the value of the runes
     * @param value the value of the rune
     */
    public void addValue(int value){
        this.value += value;
    }

    /**
     * subtract the value of the runes
     * @param value value of the rune
     */
    public void subtractValue(int value){
        this.value -= value;
    }

    /**
     * get the allowable actions
     * @return
     */
    public List<Action> getAllowableActions(){
        ActionList actions = new ActionList();
        actions.add(new RetrieveRunesAction(this));
        return actions.getUnmodifiableActionList();


    }

    /**
     * to string method
     * @return string represent the value of the rune
     */
    @Override
    public String toString(){
        return "runes: " + getValue();
    }

    /**
     * tick method
     * @param location The location of the ground on which we lie.
     */
    public void tick(Location location){
        if (this.hasCapability(Status.WIPED)){
            location.removeItem(this);
        }
    }
}
