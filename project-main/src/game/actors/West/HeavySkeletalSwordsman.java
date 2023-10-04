package game.actors.West;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;
import game.weapons.Grossmesser;

/**
 *Heavy Skeletal Swordsman
 */
public class HeavySkeletalSwordsman extends Enemy {
    /**
     * Constructor
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153, Species.SKELETAL);
        this.addCapability(Species.SWORDSMAN);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Heavy Skeletal Swordsman runes",
                RandomNumberGenerator.getRandomInt(35, 892), false));
        this.addWeaponToInventory(new Grossmesser());
    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(115, "bonks", 85);
    }
}
