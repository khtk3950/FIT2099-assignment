package game.actors;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ReviveAction;
import game.enums.Species;
import game.weapons.Grossmesser;
/**
 * Class representing the Piles Of Bones. It extends from the abstract Enemy class
 * It carries Grossmesser()
 * It will revive after 3 rounds of not being attack
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class PileOfBones extends Enemy {

    private int counter = 0;
    private Species variant;

    /**
     * Constructor
     * @param species
     */
    public PileOfBones(Species species) {
        super("Piles Of Bones", 'X', 1,Species.BONES);
        this.addWeaponToInventory(new Grossmesser());
        this.addCapability(Species.SKELETAL);
        this.addCapability(Species.BONES);
        behaviours.clear();
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
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (counter == 3) {
            return new ReviveAction(this,map,this.variant);
        } else {
            counter += 1;
        }
        return new DoNothingAction();
    }


}
