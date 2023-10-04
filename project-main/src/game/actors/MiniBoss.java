package game.actors;


import game.enums.Species;
import game.weapons.Parang;

import java.util.ArrayList;

/**
 *mini boss
 */
public class MiniBoss extends Enemy{
    /**
     * Constructor
     */
    public MiniBoss(){
        super("Guardian", '☹', 1000 , Species.GUARDIAN);
        this.behaviours.remove(3);
        this.addWeaponToInventory(new Parang());
    }
}
