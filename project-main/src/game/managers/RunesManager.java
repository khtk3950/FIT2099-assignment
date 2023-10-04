package game.managers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.items.Runes;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that manage the runes
 */
public class RunesManager {
    /**
     * runes manager
     */
    private static RunesManager runesManager = new RunesManager();
    /**
     *hash map that map actor and runes
     */
    private static Map<Actor, Runes> actorRunes = new HashMap<>();
    /**
     *hash map that map item and runes(purchase price)
     */
    private static Map<Item, Runes> purchasePrices = new HashMap<>();
    /**
     *hash map that map item and runes(sell price)
     */
    private static Map<Item, Runes> sellPrices = new HashMap<>();
    /**
     *
     */
    private static Runes droppedRunes;

    /**
     * get the runesmanager
     * @return an instance of runesmanager
     */
    public static RunesManager getRunesManager(){
        return runesManager;
    }

    /**
     *get runes item of the actor
     * @param actor
     * @return runes item of the actor
     */
    public Runes getRunesItem(Actor actor){
        Runes runes = actorRunes.get(actor);
        return runes;
    }

    /**
     *get amount of runes of the actor
     * @param actor
     * @return amount of runes of the actor
     */
    public int getRunes(Actor actor){
        Runes runes = actorRunes.get(actor);
        return runes.getValue();
    }

    /**
     *get purchase price of the item
     * @param item
     * @return purchase price of the item
     */
    public int getPurchasePrice(Item item){
        Runes runes = purchasePrices.get(item);
        return runes.getValue();
    }

    /**
     *get sell price of the item
     * @param item
     * @return sell price of the item
     */

    public int getSellPrice(Item item){
        Runes runes = sellPrices.get(item);
        return runes.getValue();
    }

    /**
     *get the dropped runes
     * @return the dropped runes
     */
    public Runes getDroppedRunes(){
        return droppedRunes;
    }

    /**
     *set the rune of the actor
     * @param actor actor that you want to set
     * @param runes rune that you want to set
     */

    public void setActorRune(Actor actor, Runes runes){
        actorRunes.put(actor, runes);
    }

    /**
     *set the purchase price of the item
     * @param item item
     * @param runes PurchasePrice
     */
    public void setPurchasePrice(Item item, Runes runes){
        purchasePrices.put(item, runes);
    }

    /**
     *set the purchase price of the item
     * @param item item
     * @param runes  SellPrice
     */
    public void setSellPrice(Item item, Runes runes){
        sellPrices.put(item, runes);
    }

    /**
     *set the dropped runes
     * @param runes dropped runes
     */
    public void setDroppedRunes(Runes runes){
        droppedRunes = runes;
    }

    /**
     *add runes to an actor
     * @param actor actor
     * @param runesValue amount of rune you want to add
     */
    public void addRunes(Actor actor, int runesValue){
        Runes runes = actorRunes.get(actor);
        runes.addValue(runesValue);
    }

    /**
     *subtract runes of an actor
     * @param actor actor
     * @param runesValue amount of rune you want to subtract
     */
    public void subtractRunes(Actor actor, int runesValue){
        Runes runes = actorRunes.get(actor);
        runes.subtractValue(runesValue);
    }

    /**
     *since you already retrieve the dropped tune, the dropped rune will become null
     */
    public void retrieveDroppedRunes(){
        droppedRunes = null;
    }

    public void removeActor(Actor actor){
        actorRunes.remove(actor);
    }
}
