package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Skill;
import game.enums.Species;
import game.items.Runes;
import game.managers.RunesManager;
import game.utils.RandomNumberGenerator;

/**
 * GodrickSoldiers
 */
public class GodrickSoldiers extends Enemy{
    /**
     * Constructor.
     */
    public GodrickSoldiers() {
        super("Godrick Soldiers", 'p', 198 , Species.GODRICK);
        RunesManager.getRunesManager().setActorRune(this,new Runes("Godrick Soldiers runes",
                RandomNumberGenerator.getRandomInt(38, 70), false));
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
