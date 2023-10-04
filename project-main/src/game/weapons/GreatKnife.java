package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickstepAction;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;
/**
 * A weapon that can be used to attack the enemy.
 *  It deals 75 damage with 70 hit rate
 */
public class GreatKnife extends WeaponItem {
    /**
     * Constructor.
     *
     */
//    Action Skill=new Quickstep();
    public GreatKnife() {
        super("GreatKnife", '/', 75, "stabs", 70);
        this.addCapability(WeaponType.PURCHASABLE);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setPurchasePrice(this, new Runes("Great Knife purchase price", 3500, false));
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Great Knife sell price", 350, false));
    }
    @Override
    public Action getSkill(Actor target, String direction){
        return new QuickstepAction(target,direction,this);
    }

}
