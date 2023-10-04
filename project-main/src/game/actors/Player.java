package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PlayerDeathResetAction;
import game.actors.roles.Roles;
import game.enums.Species;
import game.items.FlaskOfCrimsonTears;
import game.items.Runes;
import game.managers.ResetManager;
import game.managers.RunesManager;
import game.weapons.Club;
import game.managers.Resettable;
import game.enums.Status;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {
	private final Menu menu = new Menu();
	private Location lastLostGrace;
	private Location lastLocation;
	private Roles role;
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints, Location lastLostGrace, Roles role) {
		super(name, displayChar, hitPoints);
		this.setLastLostGrace(lastLostGrace);
		this.addCapability(Species.PLAYER);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(role.getStartingWeapon());
		this.addItemToInventory(new FlaskOfCrimsonTears("Flask of Crimson Tears", 'c'));
		this.role=role;
		this.setLastLocation(lastLostGrace);
		RunesManager.getRunesManager().setActorRune(this, new Runes("Player runes", 0, true));
		ResetManager.getResetManager().registerResettable(this);
	}
	/**
	 * Select and return an action to perform on the current turn.
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		if (this.hasCapability(Status.DEAD)){
			this.removeCapability(Status.DEAD);
			return new PlayerDeathResetAction(this, map);
		}
		this.setLastLocation(map.locationOf(this));
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		System.out.println(this.name + " " +  this.printHp() + ", runes: " +
				(RunesManager.getRunesManager().getRunes(this)));
		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * get the location of last lost grace
	 * @return the location of last lost grace
	 */
	public Location getLastLostGrace(){
		return this.lastLostGrace;
	}

	/**
	 * set the last lost grace
	 * @param location location of last lost grace
	 */
	public void setLastLostGrace(Location location){
		this.lastLostGrace=location;
	}

	/**
	 *
	 * @return
	 */
	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}

	@Override
	public void reset() {this.increaseMaxHp(0);}
}
