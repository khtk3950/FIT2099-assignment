package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * wall, You shall not pass！
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {
	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
	}

	/**
	 * no actor can enter here
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * block the throw object
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
