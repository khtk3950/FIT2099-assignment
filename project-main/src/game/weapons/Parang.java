package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickstepAction;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;
/**
 * A weapon with special skill that is quick step
 * It deals 800 damage with 40% hit rate
 */
public class Parang extends WeaponItem {
    /**
     * Constructor.
     *
     */
    public Parang() {
        super("Parang", '⛏', 800, "chop", 40);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Parang sell price", 350, false));
    }
    @Override
    public Action getSkill(Actor target, String direction){
        return new QuickstepAction(target,direction,this);
    }

}