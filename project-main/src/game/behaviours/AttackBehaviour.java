package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AreaAttackAction;
import game.actions.AttackAction;
import game.enums.Skill;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {
	
	private final Random random = new Random();
	private final Actor target;
	private final String direction;
	public AttackBehaviour(Actor subject, String direction) {
		this.target = subject;
		this.direction = direction;
	}
	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor attacker, GameMap map) {
		ArrayList<Action> actions = new ArrayList<>();
		if(!map.contains(target)){
			return null;
		}
		//normal attack with intrinsic weapon
		actions.add(new AttackAction(target, direction));
		if(attacker.hasCapability(Skill.AOE_ATTACK)){
			actions.add(new AreaAttackAction(target,direction));
		}
		for(Weapon weapon : attacker.getWeaponInventory()) {
			//normal attack with weapon
			actions.add(new AttackAction(target,direction,weapon));
			//attack with weapon skill
			if(RandomNumberGenerator.getRandomInt(0,100)<= 50)
				return(weapon.getSkill(target,direction));
		}
		
		if (!actions.isEmpty()) {
			return actions.get(random.nextInt(actions.size()));
		}
		else {
			return null;
		}

	}
}
