package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * A weapon that can be used to attack the enemy.
 *  It deals 142 damage with 84 hit rate
 */
public class AxeOfGodrick extends WeaponItem {
    /**
     * Constructor
     */
    public AxeOfGodrick() {
        super("Axe of Godrick", 'T', 142, "chops", 84);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Axe Of Godrick sell price", 100, false));
    }


}
