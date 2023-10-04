package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.PurchaseAction;
import game.actions.SellAction;
import game.actions.SellRemembranceAction;
import game.enums.RemembranceType;
import game.enums.Species;
import game.enums.WeaponType;

/**
 * Trader
 */
public class Trader extends Actor {
    /**
     * Constructor
     * @param name name of the actor
     * @param displayChar char used to display actor
     */
    public Trader(String name, char displayChar){
        super(name, displayChar, 100);
        this.addCapability(Species.MERCHANT);
    }
    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Species.PLAYER)){
            for (WeaponItem weapon : otherActor.getWeaponInventory()){
                if (weapon.hasCapability(WeaponType.SELLABLE)){
                    actions.add(new SellAction(weapon));
                }
            }
            for (WeaponItem weapon: getWeaponInventory()){
                if (weapon.hasCapability(WeaponType.PURCHASABLE) ){
                    actions.add(new PurchaseAction(weapon));
                }
            }
            for (Item item: otherActor.getItemInventory()){
                if (item.hasCapability(RemembranceType.GRAFTED)){
                    actions.add(new SellRemembranceAction(item));
                }
            }
        }
        return actions;
    }

}
