package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.managers.RunesManager;

/**
 * An action to sell an item
 */
public class SellAction extends Action {
    //private Trader trader;
    /**
     * product is to be sold
     */
    private WeaponItem product;
    /**
     * runes manager
     */
    private RunesManager runesManager = RunesManager.getRunesManager();
    /**
     * price of the product
     */
    int productPrice;

    /**
     * Constructor
     * @param product product is to be sold
     */
    public SellAction(WeaponItem product){
        //this.trader = trader;
        this.product = product;
        this.productPrice = runesManager.getSellPrice(product);
    }

    /**
     * When executed it will add the amount of runes that is equal to the price of the product to the seller.
     * After that, it will remove the product from the seller inventory.
     * @param seller The actor performing the action.
     * @param map The map the actor is on.
     * @return the result of selling.
     */
    @Override
    public String execute(Actor seller, GameMap map) {
        runesManager.addRunes(seller, productPrice);
        seller.removeWeaponFromInventory(this.product);
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
