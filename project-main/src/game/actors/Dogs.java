package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Skill;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * dogs
 */
public class Dogs extends Enemy{
    /**
     * Constructor
     */
    public Dogs() {
        super("Dogs", 'a', 104 , Species.DOG);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Dogs runes",
                RandomNumberGenerator.getRandomInt(52, 1390), false));
    }
    /**
     * Get the intrinsic weapon of the actor
     * @return the intrinsic weapon of the actor
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }
}
