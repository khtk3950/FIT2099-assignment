package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.Random;

/**
 * An Action to attack another Actor.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class AreaAttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	private Actor target;

	/**
	 * The direction of incoming attack.
	 */
	private String direction;

	/**
	 * Random number generator
	 */
	private Random rand = new Random();

	/**
	 * Weapon used for the attack
	 */
	private Weapon 	weapon;

	/**
	 * Skill used for the attack
	 */


	/**
	 * Constructor with skill attack from the weapon
	 *
	 * @param target the actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AreaAttackAction(Actor target, String direction, Weapon weapon) {
		this.target = target;
		this.direction = direction;
		this.weapon = weapon;
	}

	/**
	 * Constructor with skill attack from skill
	 *
	 * @param target the actor to attack
	 * @param direction the direction where the attack should be performed (only used for display purposes)
	 */
	public AreaAttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

//	/**
//	 * Constructor with intrinsic weapon as default
//	 *
//	 * @param target the actor to attack
//	 * @param direction the direction where the attack should be performed (only used for display purposes)
//	 */
//	public AreaAttackAction(Actor target, String direction) {
//		this.target = target;
//		this.direction = direction;
//	}
//
//	/**
//	 * Constructor with skill attack from the weapon
//	 *
//	 * @param target the actor to attack
//	 * @param direction the direction where the attack should be performed (only used for display purposes)
//	 */
//	public AreaAttackAction(Actor target, String direction, Weapon weapon, Skill skill) {
//		this.target = target;
//		this.direction = direction;
//		this.weapon = weapon;
//		this.skill= skill;
//	}


	/**
	 * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
	 * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
	 *
	 * @param attacker The actor performing the attack action.
	 * @param map The map the actor is on.
	 * @return the result of the attack, e.g. whether the target is killed, etc.
	 * @see NormalDeathAction
	 */
	@Override
	public String execute(Actor attacker, GameMap map) {
		/**
		 * Getting all the actors around the attacker, since the area attack will damage all the surrounding actor
		 **/
		String result = attacker + " performs an Area Attack";
		if(!map.contains(target)){
			return null;
		}

		for(Exit exits : map.locationOf(attacker).getExits()){
			if(exits.getDestination().containsAnActor()){
				result += System.lineSeparator() + new AttackAction(exits.getDestination().getActor(),direction, weapon).execute(attacker, map);
			}
		}

		/**
		 * Check if area attack is perform using weapon or just intrinsic weapon
		 **/
		if (weapon == null) {
			weapon = attacker.getIntrinsicWeapon();
		}


		/**
		 * Then for each actor around the attacker we perform an actor
		 **/
//		String result = attacker + " performs an Area Attack";
//		for(Actor target : targets){
//			new AttackAction(target,direction, weapon).execute(attacker, map);
//		}

		return result;
	}

	/**
	 * Describes which target the actor is attacking with which weapon
	 *
	 * @param actor The actor performing the action.
	 * @return a description used for the menu UI
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction + " with Area attack.";
	}
}
