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
 *  It deals 89 damage with 90 hit rate
 */
public class GraftedDragon extends WeaponItem {
    /**
     * Constructor
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "chops", 90);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Grafted Dragon sell price", 200, false));
    }

}