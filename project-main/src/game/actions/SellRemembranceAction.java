package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.managers.RunesManager;

/**
 * A action that sell the Remembrance of the Grafted
 */
public class SellRemembranceAction extends Action {
    /**
     *The product to be sold, in this case Remembrance of the Grafted
     */
    private Item product;
    /**
     *runes manager
     */
    private RunesManager runesManager = RunesManager.getRunesManager();
    /**
     *price of the product
     */
    int productPrice;

    /**
     * Constructor
     * @param remembrance
     */
    public SellRemembranceAction(Item remembrance){
        this.product = remembrance;
        this.productPrice = runesManager.getSellPrice(remembrance);
    }

    /**
     *When executed it will add the amount of runes that is equal to the price of the product to the seller.
     *  After that, it will remove the product from the seller inventory.
     * @param seller The actor performing the action.
     * @param map The map the actor is on.
     * @return  result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor seller, GameMap map) {
        runesManager.addRunes(seller, productPrice);
        seller.removeItemFromInventory(this.product);
        return seller + " has sold " + this.product.toString() + ".";
    }

    /**
     *
     * @param seller The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor seller) {
        return seller + " sells " + this.product.toString() + " for " +
                productPrice;
    }
}
