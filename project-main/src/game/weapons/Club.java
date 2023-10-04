package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Club extends WeaponItem {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        this.addCapability(WeaponType.PURCHASABLE);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setPurchasePrice(this, new Runes("Club purchase price", 600, false));
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Club sell price", 100, false));
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
