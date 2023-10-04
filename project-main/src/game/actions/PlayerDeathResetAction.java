package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.enums.Status;
import game.items.Runes;
import game.managers.ResetManager;
import game.managers.RunesManager;
import game.utils.FancyMessage;

/**
 *An action to reset the map after a player died.
 */
public class PlayerDeathResetAction extends Action {
    /**
     * The player
     */
    Player player;
    /**
     * The map player is on
     */
    GameMap map;

    /**
     * Constructor
     * @param player The player
     * @param map The map player is on
     */
    public PlayerDeathResetAction(Player player, GameMap map){
        this.player = player;
        this.map = map;
    }

    /**
     * When executed, it will check if there is instance a dropped rune on map, if there is it will be
     * wiped.Then the rune of the player will be dropped on the ground,the player will be move
     * to the last lost grace.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a death message
     */
    public String execute(Actor actor, GameMap map){
        RunesManager runesManager = RunesManager.getRunesManager();
        int runeValue = runesManager.getRunes(player);
        // check if there is an instance of a dropped rune
        if (runesManager.getDroppedRunes() != null){
            // Give dropped instance a capability that will cause a line of code
            // In tick() to run which removes it from map
            runesManager.getDroppedRunes().addCapability(Status.WIPED);
        }
        runesManager.setDroppedRunes(new Runes("Dropped runes", runeValue,false));
        player.getLastLocation().addItem(runesManager.getDroppedRunes());
        runesManager.subtractRunes(player, runeValue);
        map.moveActor(player, player.getLastLostGrace());
        ResetManager.getResetManager().run();

        return System.lineSeparator() + FancyMessage.YOU_DIED;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    public String menuDescription(Actor actor){
        return "";
    }

}
