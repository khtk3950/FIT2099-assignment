package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 *An action that allow player exchange  Remembrance of the Grafted for  either
 * the Axe of Godrick or Grafted Dragon.
 */
public class ExchangeAction extends Action {
    /**
     *The item you use to exchange stuff
     */
    private Item item;
    /**
     * The item you get from exchanging
     */
    private WeaponItem weapon;

    /**
     * Constructor.
     * @param item The item you use to exchange stuff
     * @param weapon The item you get from exchanging
     */
    public ExchangeAction(Item item, WeaponItem weapon){
        this.item = item;
        this.weapon = weapon;
    }

    /**
     * When execute it will remove the item using to exchange from the actor inventory and add the item
     * that actor wish to exchange to actor's inventory
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        actor.removeItemFromInventory(item);
        actor.addWeaponToInventory(weapon);
        return actor + " exchanged remembrance for " + weapon;

    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " exchanges remembrance for " + weapon;
    }
}
