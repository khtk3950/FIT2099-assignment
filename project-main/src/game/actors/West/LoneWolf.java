package game.actors.West;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, wolf!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class LoneWolf extends Enemy {
    /**
     * Constructor
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102 , Species.LAND);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Lone Wolf runes",
                RandomNumberGenerator.getRandomInt(55, 1470), false));
    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }
}
