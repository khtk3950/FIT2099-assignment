package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.PileOfBones;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * An action executed if a skeletal is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class SkeletalDeathAction extends Action {
    /**
     * the actor that killed the target
     */
    private Actor attacker;

    /**
     * Constructor
     * @param actor  the actor that killed the target
     */
    public SkeletalDeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     *
     *When execute, it will remove the target on map.If the target is removed it will spawn the
     * piles of bone according to the species of the target.
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        Location temp = map.locationOf(target);
        map.removeActor(target);
        if(!temp.containsAnActor()) {
            if (target.hasCapability(Species.SWORDSMAN)) {
                PileOfBones pileOfBones = new PileOfBones(Species.SWORDSMAN);
                Runes runesItem = RunesManager.getRunesManager().getRunesItem(target);
                RunesManager.getRunesManager().setActorRune(pileOfBones, runesItem);
                temp.addActor(pileOfBones);
            } else {
                PileOfBones pileOfBones = new PileOfBones(Species.BANDIT);
                Runes runesItem = RunesManager.getRunesManager().getRunesItem(target);
                RunesManager.getRunesManager().setActorRune(pileOfBones, runesItem);
                temp.addActor(pileOfBones);
            }
        }

        result += System.lineSeparator() + menuDescription(target);
        return result;
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " dies to spawn Pile of Bones";
    }
}

