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
 *  A weapon with special skill that is spinning attack
 * It deals 118 damage with 88% hit rate
 */
public class Scimitar extends WeaponItem {

    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "bonks", 88);
        this.addCapability(WeaponType.PURCHASABLE);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setPurchasePrice(this, new Runes("Scimitar purchase price", 600, false));
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Scimitar sell price", 100, false));
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(target, direction, this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
