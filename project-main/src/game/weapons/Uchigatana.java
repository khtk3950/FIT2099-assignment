package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.UnsheatheAction;
import game.enums.WeaponType;
import game.items.Runes;
import game.managers.RunesManager;
/**
 *  A weapon with special skill that is Unsheathe
 * It deals 115 damage with 80% hit rate
 */
public class Uchigatana extends WeaponItem {
//    Action Skill=new Unsheathe();
    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
        this.addCapability(WeaponType.PURCHASABLE);
        this.addCapability(WeaponType.SELLABLE);
        RunesManager.getRunesManager().setPurchasePrice(this, new Runes("Great Knife purchase price", 5000, false));
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Great Knife sell price", 500, false));
    }
    public Action getSkill(Actor target, String direction){
        return new UnsheatheAction(target,direction,this);
    }

}

