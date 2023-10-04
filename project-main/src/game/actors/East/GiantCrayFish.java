package game.actors.East;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Enemy;
import game.enums.Skill;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, CrayFish!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class GiantCrayFish extends Enemy {
    /**
     * Constructor
     */
    public GiantCrayFish() {
        super("Giant Cray Fish", 'R', 4803 , Species.WATER);
        this.addCapability(Skill.AOE_ATTACK);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Giant Cray Fish runes",
                RandomNumberGenerator.getRandomInt(35, 892), false));

    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slam", 100);
    }
}
