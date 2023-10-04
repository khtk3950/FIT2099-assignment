package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Ally;
import game.actors.Invader;
import game.actors.Summoned;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An action to summon Allies or Invader
 */
public class SummonAction extends Action {
    /**
     *The location to summon the allies/invader
     */
    private Location location;
    /**
     *The empty exits for the allies/invader
     */
    private List<Exit> emptyExits = new ArrayList<>();
    /**
     * The instance of allies/invader
     */
    private Summoned creature;
    /**
     * random value
     */
    private final Random random = new Random();

    /**
     * Constructor
     * @param location The location to summon the allies/invader
     */
    public SummonAction(Location location){
        this.location=location;
        this.creature=setCreature();
    }

    /**
     *Randomly choose allies or invader to be summoned
     * @return the choice.
     */
    public Summoned setCreature(){
        ArrayList<Summoned> creatures = new ArrayList<>();
        creatures.add(new Ally("Dummy",'A',0));
        creatures.add(new Invader("Dummy",'ඞ',0));
        return creatures.get(random.nextInt(creatures.size()));
    }

    /**
     *If there is empty exit at the location it will add the allies/invader to the empty exit.
     * If not,it will return "No space to spawn".
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of spawning,eg: The allies/invader is spawn or there is no space to spawn.
     */
    public String execute(Actor actor, GameMap map) {
        for(Exit exits : location.getExits()) {
            if (!exits.getDestination().containsAnActor()) {
                emptyExits.add(exits);
            }
        }
        if(emptyExits.size()!=0) {
            emptyExits.get(0).getDestination().addActor(creature);
            String result = creature + " is spawned";
            return result;
        }
        return "No space to spawn";
    }

    /**
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    public String menuDescription(Actor actor){
        return "Summon Ally/Invader";
    }
}

