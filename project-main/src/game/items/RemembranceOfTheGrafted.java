package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.ExchangeAction;
import game.actions.SellAction;
import game.actions.SellRemembranceAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.enums.RemembranceType;
import game.enums.Species;
import game.enums.Status;
import game.managers.RunesManager;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

/**
 *Remembrance of the Grafted item
 */
public class RemembranceOfTheGrafted extends Item {
    /**
     * Constructor
     */
    public RemembranceOfTheGrafted(){
        super("Remembrance of the Grafted", 'O', true);
        this.addCapability(RemembranceType.GRAFTED);
        RunesManager.getRunesManager().setSellPrice(this, new Runes("Remembrance of the Grafted sell price", 20000
        , false));
    }


}
