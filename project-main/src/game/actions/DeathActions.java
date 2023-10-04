package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Species;
import game.enums.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class DeathActions extends Action {
    /**
     * the actor that killed the target
     */
    private Actor attacker;

    /**
     *
     * @param actor the actor that killed the target
     */
    public DeathActions(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When executed, if the target is skeletal it will execute SkeletalDeathAction, if it is actor
     * other than player it will execute NormalDeathAction. If it is a player, it will add dead status to player
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        if(target.hasCapability(Species.SKELETAL)&!target.hasCapability(Species.BONES)){
            result += new SkeletalDeathAction(target).execute(target,map);
        }else if (target.hasCapability(Species.PLAYER)){
            target.addCapability(Status.DEAD);
        }else{
            result += new NormalDeathAction(target).execute(target,map);
        }
        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

}