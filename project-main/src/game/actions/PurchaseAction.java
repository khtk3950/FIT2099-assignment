package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.managers.RunesManager;

/**
 * An action that purchase an item
 */
public class PurchaseAction extends Action {
    //private Trader trader;
    /**
     * The product that you want to purchase
     */
    private WeaponItem product;
    /**
     * runes manager
     */
    private RunesManager runesManager = RunesManager.getRunesManager();
    /**
     * The price of the product
     */
    int productPrice;

    /**
     * Constructor
     * @param product The product that you want to purchase
     */
    public PurchaseAction(WeaponItem product){
        //this.trader = trader;
        this.product = product;
        this.productPrice = runesManager.getPurchasePrice(product);
    }

    /**
     *When executed it will check if you have enough runes to purchase the item, if you have enough rune
     * it will subtract the price of the product from your rune and add the item in your inventory.
     * If you don't have enough rune it will tell you, you don't have enough rune.
     * @param purchaser The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the purchase eg: whether the purchase is successful or you don't have enough
     * rune to make the purchase.
     */
    @Override
    public String execute(Actor purchaser, GameMap map) {
        String result = "";
        if(runesManager.getRunes(purchaser) < productPrice){
            result += purchaser + " does not have enough runes to purchase " + product + "!";
            return result;
        }
        runesManager.subtractRunes(purchaser, productPrice);
        purchaser.addWeaponToInventory(this.product);
        result += purchaser + " has purchased " + this.product.toString() + ".";
        return result;
    }

    /**
     *
     * @param purchaser The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor purchaser) {
        return purchaser + " purchases " + this.product.toString() + " for " +
                productPrice;
    }
}
