package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * An action that let the actor retrieve the rune on the ground
 */
public class RetrieveRunesAction extends PickUpAction {
    /**
     *rune
     */
    Runes runes;
    /**
     * rune manager
     */
    RunesManager runesManager = RunesManager.getRunesManager();

    /**
     * Constructor
     * @param runes rune
     */
    public RetrieveRunesAction(Runes runes){
        super(runes);
        this.runes = runes;
    }

    /**
     *When executed it will add the rune actor retrieve to the actor and the rune on groud will be wiped.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the result like how the actor retrieved how many runes.
     */
    @Override
    public String execute(Actor actor, GameMap map){
        String result = "";
        runesManager.addRunes(actor, runes.getValue());
        // WIPED to make sure it despawns on next tick
        runes.addCapability(Status.WIPED);
        // Remove it from droppedRunes attribute
        runesManager.retrieveDroppedRunes();
        result += actor + " retrieved Runes (value: " + runes.getValue() + ")";
        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor){
        String result = "";
        result += actor + " retrieves Runes (value: " + runes.getValue() + ")";
        return result;
    }
}
