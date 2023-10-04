package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.grounds.SiteOfLostGrace;
import game.managers.ResetManager;

/**
 * An action to rest at the site of lost grace
 */
public class RestAction extends Action {
    /**
     * name of the site of lost grace
     */
    SiteOfLostGrace site;

    /**
     * Constructor
     * @param site name of the site of lost grace
     */
    public RestAction(SiteOfLostGrace site){
        this.site = site;
    }

    /**
     * When executed it will reset the map and return a message the player rest at the site of lost grace
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return a String that player had rest at site of lost grace
     */
    @Override
    public String execute(Actor actor, GameMap gameMap){
        ResetManager.getResetManager().run();

        return actor + " rested at the " + site + " Site of Lost Grace.";
    };

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor){
        return actor + " rests at the " + site + " Site of Lost Grace.";
    }
}
