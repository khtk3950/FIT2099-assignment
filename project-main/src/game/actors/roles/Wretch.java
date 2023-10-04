package game.actors.roles;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.weapons.Club;

/**
 * wretch role
 */
public class Wretch extends Roles{
    /**
     * starting weapon of the role
     */
    WeaponItem startingWeapon= new Club();
    /**
     *  starting  hit point  of the role
     */
    int StartingHitPoint=414;
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

