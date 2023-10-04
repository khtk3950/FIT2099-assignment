package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * An action to consume an item
 */
public class ConsumeItemAction extends Action {
    /**
     * The item that will be consumed
     */
    Consumable consumableItem;
    public ConsumeItemAction(Consumable consumableItem){
        this.consumableItem = consumableItem;

    }

    /**
     *When executed,it will check if the item still have numOfuses greater than 0,if so it will consume
     * the item and return the result.If it doesn't have any numofuses left it will return a item is empty message.
     * @param consumer The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return the result of consuming the item.eg: whether the item is successfully consume or not or it is empty.
     */
    @Override
    public String execute(Actor consumer, GameMap gameMap){
        String result = "";
        int numOfUses = consumableItem.getNumOfUses();
        int maxUses = consumableItem.getMaxUses();
        if (numOfUses > 0) {
            consumableItem.consumeItem(consumer);
            result += consumer + " consumed " + consumableItem + " " + consumableItem.printUses();
        }
        else if (numOfUses == 0){
            result += consumableItem + " (" + Integer.toString(numOfUses) + "/" +
                    Integer.toString(maxUses) + ") is empty.";
        }
        return result;
    }

    /**
     *
     * @param consumer The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor consumer){
        return consumer + " consumes " + consumableItem + " " + consumableItem.printUses();
    }
}
