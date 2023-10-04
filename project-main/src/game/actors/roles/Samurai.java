package game.actors.roles;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Uchigatana;

/**
 * samurai role
 */
public class Samurai extends Roles {
    /**
     * starting weapon of the role
     */
    WeaponItem startingWeapon= new Uchigatana();
    /**
     *  starting  hit point  of the role
     */
    int StartingHitPoint=455;
    /**
     *get the  starting weapon of the role
     * @return starting weapon of the role
     */
    public WeaponItem getStartingWeapon() {
        return startingWeapon;
    }
    /**
     *get the starting hit point of the role
     * @return starting hit point of the role
     */
    public int getStartingHitPoint() {
        return StartingHitPoint;
    }
}
