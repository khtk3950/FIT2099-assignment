package game.actors.West;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Skill;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, crab!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class GiantCrab extends Enemy {
    /**
     * Constructor
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407 , Species.WATER);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Giant Crab runes",
                RandomNumberGenerator.getRandomInt(318, 4961), false));
        this.addCapability(Skill.AOE_ATTACK);
    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "bites", 90);
    }
}
