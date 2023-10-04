package game.actors.East;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * Skeletal Bandit
 */
public class SkeletalBandit extends Enemy {
    /**
     * Constructor
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184, Species.SKELETAL);
        this.addCapability(Species.BANDIT);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Heavy Skeletal Swordsman runes",
                RandomNumberGenerator.getRandomInt(35, 892), false));
    }

    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(118, "", 88);
    }
    public void reset(){

    }
}
