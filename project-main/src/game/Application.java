package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.FingerReader;
import game.actors.MiniBoss;
import game.actors.Player;
import game.actors.Trader;
import game.actors.roles.*;
import game.enums.Status;
import game.grounds.*;
import game.items.GoldenRunes;
import game.items.RemembranceOfTheGrafted;
import game.utils.FancyMessage;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Scimitar;
import game.weapons.Uchigatana;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {
	/**
	 * start the game
	 * @param args
	 */
	public static void main(String[] args) {

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),new PuddleOfWater(), new Graveyard(), new GustOfWind(), new Cliff(), new Summon(), new Cage(), new Barrack(), new Rot());

		List<String> limgrave = Arrays.asList(
				"......................#.............#..........................+++.........",
				"......................#.............#.......................+++++..........",
				"......................#..___....____#.........................+++++........",
				"......................#...........__#............................++........",
				"........~.............#_____........#.............................+++......",
				".......~~............#............_#............=..................+++.....",
				"........~.............######...######......................................",
				"...................................................&&......................",
				"..................................................&&.......................",
				"........++++......&........&......###___###.........&......................",
				"........+++++++..&n&......&n&.....________#................................",
				"..........+++.....&&&&&&&&&&......#________......=.........................",
				"............+++...................#_______#..............=......~..........",
				".............+....................###___###....................~~..........",
				"............++......................#___#.......................~..........",
				"..............+...................=............................~~..........",
				"..............++.................................................=.........",
				"..............................................++...........................",
				"..................++++......................+++...............######..##...",
				"#####___######....++...........................+++............#....____....",
				"_____________#.....++++..........................+..............__.....#...",
				"_____________#.....+....++........................++.........._.....__.#...",
				"_____________#.........+..+.....................+++...........###..__###...",
				"_____________#.............++..............................................");
		List<String> stormveilCastle = Arrays.asList(
				"...........................................................................",
				"..................<...............<........................................",
				"...........................................................................",
				"##############################################...##########################",
				"............................#................#.......B..............B......",
				".....B...............B......#................#.............................",
				"...............................<.........<.................................",
				".....B...............B......#................#.......B..............B......",
				"............................#................#.............................",
				"#####################..#############...############.####..#########...#####",
				"...............#++++++++++++#................#++++++++++++#................",
				"...............#++++++++++++...<.........<...#++++++++++++#................",
				"...............#++++++++++++..................++++++++++++#................",
				"...............#++++++++++++#................#++++++++++++#................",
				"#####...##########.....#############...#############..#############...#####",
				".._______........................B......B........................B.....B...",
				"_____..._..____....&&........<..............<..............................",
				".........____......&&......................................................",
				"...._______..................<..............<....................<.....<...",
				"#####....##...###..#####...##########___###############......##.....####...",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
				"+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++"
		);
		List<String> roundtableHold = Arrays.asList(
				"##################",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"#________________#",
				"########___#######"
		);
		List<String> bossRoom = Arrays.asList(
				"+++++++++++++++++++++++++",
				".........................",
				"..=......................",
				".........................",
				".........................",
				".........................",
				".........................",
				".........................",
				"+++++++++++++++++++++++++"
		);

		List<String> LakeOfRots = Arrays.asList(
				"+++++++++++++++++++++++++",
				".....^^^^^^^^^...........",
				"............^^...........",
				"......^^^^^..............",
				"............^^^^^........",
				"....^^^^^................",
				"........^^^^^^^^^^^......",
				".........................",
				"+++++++++++++++++++++++++"
		);

		GameMap limgraveMap = new GameMap(groundFactory, limgrave);
		GameMap stormveilCastleMap = new GameMap(groundFactory, stormveilCastle);
		GameMap roundtableHoldMap = new GameMap(groundFactory, roundtableHold);
		GameMap bossRoomMap = new GameMap(groundFactory, bossRoom);
		GameMap lakeOfRotsMap = new GameMap(groundFactory, LakeOfRots);
		world.addGameMap(limgraveMap);
		world.addGameMap(stormveilCastleMap);
		world.addGameMap(roundtableHoldMap);
		world.addGameMap(bossRoomMap);
		world.addGameMap(lakeOfRotsMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}


		// HINT: what does it mean to prefer composition to inheritance?
		//ask the player to select their role
		Scanner sel = new Scanner(System.in);
		String choice;
		System.out.println("Select your role");
		System.out.println("b: Bandit");
		System.out.println("s: Samurai");
		System.out.println("w: Wretch");
		System.out.println("a: Astrologer");
		choice = sel.nextLine();
		System.out.println(choice);
		Roles role;
		if (choice.equals("b")){
			role=new Bandit();
		}
		else if (choice.equals("s")){
			role=new Samurai();
		}
		else if (choice.equals("w")){
			role=new Wretch();
		}
		else if (choice.equals("a")){
			role=new Astrologer();
		}
		else{
			throw new IllegalArgumentException("Invalid choice");
		}

		Player player = new Player("Tarnished", '@', role.getStartingHitPoint(), limgraveMap.at(38,12), role);
		limgraveMap.at(38,12).setGround(new SiteOfLostGrace("The First Step"));

		world.addPlayer(player, limgraveMap.at(38, 12));
		Trader merchantKale = new Trader("Merchant Kale",'K');
		merchantKale.addWeaponToInventory(new Club());
		merchantKale.addWeaponToInventory(new Uchigatana());
		merchantKale.addWeaponToInventory(new GreatKnife());
		merchantKale.addWeaponToInventory(new Scimitar());
		limgraveMap.at(40,12).addActor(merchantKale);
		limgraveMap.at(30,0).setGround(new GoldenFogDoor(stormveilCastleMap.at(38, 23), "Stormveil Castle"));
		limgraveMap.at(38,18).setGround(new GoldenFogDoor(lakeOfRotsMap.at(0,4),"Lakes of Rots"));
		limgraveMap.at(5, 23).setGround(new GoldenFogDoor(roundtableHoldMap.at(9,10), "Roundtable Hold"));
		stormveilCastleMap.at(38,23).setGround(new GoldenFogDoor(limgraveMap.at(30,0),"Limgrave"));
		roundtableHoldMap.at(9,10).setGround(new GoldenFogDoor(limgraveMap.at(5,23),"Limgrave"));
		stormveilCastleMap.at(5,0).setGround(new GoldenFogDoor(bossRoomMap.at(0,4),"Godrick the Grafted"));
		lakeOfRotsMap.at(0, 4).setGround(new GoldenFogDoor(limgraveMap.at(38,18), "Limgrave"));
		lakeOfRotsMap.at(1,1).addActor(new MiniBoss());
		limgraveMap.at(38,10).addItem(new GoldenRunes());
		limgraveMap.at(35,10).addItem(new GoldenRunes());
		// Player travels to Godrick the Grafted
		FingerReader fingerReaderEnia = new FingerReader("Finger Reader Enia", 'E');
		roundtableHoldMap.at(9,1).addActor(fingerReaderEnia);
		player.addItemToInventory(new RemembranceOfTheGrafted());
		world.run();
	}
}
