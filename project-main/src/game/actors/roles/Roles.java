package game.actors.roles;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * role of the actor
 */
public abstract class Roles {
    /**
     * starting weapon of the role
     */
    WeaponItem startingWeapon;
    /**
     *  starting  hit point  of the role
     */
    int StartingHitPoint;
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

