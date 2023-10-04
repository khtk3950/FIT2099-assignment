package game.actors.East;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class GiantDog extends Enemy {
    /**
     * Constructor
     */

    public GiantDog() {
        super("Giant Dog", 'G', 693 , Species.LAND);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Giant Dog runes",
                RandomNumberGenerator.getRandomInt(313, 1808), false));
    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(314, "bites", 90);
    }
}
