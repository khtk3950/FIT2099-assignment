package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AreaAttackAction;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * A weapon with special skill that is spinning attack
 * It deals 115 damage with 85% hit rate
 */
public class Grossmesser extends WeaponItem {

    /**
     * Constructor
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "bonks", 85);
        this.addCapability(WeaponType.PURCHASABLE);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Grossmesser sell price", 100, false));
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(target, direction, this);
    }

}
