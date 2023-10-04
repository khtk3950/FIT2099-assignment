package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.Species;
import game.enums.Status;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class NormalDeathAction extends Action {
    /**
     *  the actor that killed the target
     */
    private Actor attacker;

    /**
     *Constructor
     * @param actor  the actor that killed the target
     */
    public NormalDeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *If the attacker is player, he will get the rune that the target drops.
     * After that the target will be remove from map.
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        ActionList dropActions = new ActionList();
        //Need to modify abit specially for the Player DeathAction, since after the Player death the game will reset
        // check if actor is player using <<Enum>> Status, if yes then it will call the actor reset() method then the game will reset
        // drop all items
        for (Item item : target.getItemInventory())
            dropActions.add(item.getDropAction(target));
        for (WeaponItem weapon : target.getWeaponInventory())
            dropActions.add(weapon.getDropAction(target));
        for (Action drop : dropActions)
            drop.execute(target, map);
        // if player is attacker, transfer runes to player
        if(attacker.hasCapability(Species.PLAYER)) {
            RunesManager runesManager = RunesManager.getRunesManager();
            int runeValue = runesManager.getRunes(target);
            runesManager.addRunes(attacker, runeValue);
            result += System.lineSeparator() + target + " drops " + Integer.toString(runeValue) + " runes.";
        }
        // remove actor
        map.removeActor(target);
        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return  a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
