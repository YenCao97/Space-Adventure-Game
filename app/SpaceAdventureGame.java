package de.htwberlin.prog1.sose2021.spaceadventure.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import de.htwberlin.prog1.sose21.spaceadventure.model.Artefact;
import de.htwberlin.prog1.sose21.spaceadventure.model.CountStrings;
import de.htwberlin.prog1.sose21.spaceadventure.model.ListSpaceShip;
import de.htwberlin.prog1.sose21.spaceadventure.model.Planet;
import de.htwberlin.prog1.sose21.spaceadventure.model.Puzzle;
import de.htwberlin.prog1.sose21.spaceadventure.model.Reverse;
import de.htwberlin.prog1.sose21.spaceadventure.model.TicTacToe;

/**
 * The SpaceAdventureGame class contains planets, types of game and artefact
 */
public class SpaceAdventureGame {

	// Attribute
	public static ArrayList<Planet> planets = new ArrayList<Planet>();
	public static CountStrings puzzle1 = new CountStrings();
	public static TicTacToe puzzle2 = new TicTacToe();
	public static Reverse puzzle3 = new Reverse();
	public static ArrayList<Puzzle> listPuzzle = new ArrayList<Puzzle>();
	public static ArrayList<Artefact> listArtefact = new ArrayList<Artefact>();

	/**
	    * Call out 2 methods gamePacket() and createPlanet()
	    * 
	    */
	public static void showPlanet() {
		gamePacket();
		createPlanet();	
	}

	// Operations
	/**
	    * Add 3 games to arraylist "listPuzzle" and shuffle elements of this arraylist
	    */
	public static void gamePacket() {
		listPuzzle.add(puzzle1);
		listPuzzle.add(puzzle2);
		listPuzzle.add(puzzle3);
		Collections.shuffle(listPuzzle);
	}

	/**
	    * Create 3 artefacts for 3 planets
	    */
	public static void createPlanet() {
		
		// Create 3 artefacts and add to list artefact
		Artefact a1 = new Artefact("Fairy",
				"The best moves for Clefairy are Pound and Moonblast when attacking Pokémon in Gyms. This move combination has the highest total DPS and is also the best moveset for PVP battles.");
		listArtefact.add(a1);
		
		Artefact a2 = new Artefact("Grass",
				"The best moves for Bulbasaur are Vine Whip and Power Whip when attacking Pokémon in Gyms. This move combination has the highest total DPS and is also the best moveset for PVP battles.");
		listArtefact.add(a2);
		Artefact a3 = new Artefact("Fire",
				"The best moves for Vulpix are Quick Attack and Weather Ball when attacking Pokémon in Gyms. This move combination has the highest total DPS and is also the best moveset for PVP battles.");
		listArtefact.add(a3);
		
		// Create 3 planets and add to list planet
		Planet p1 = new Planet("Clefairy", "This planet is vulnerable to Steel and Poison moves.", puzzle1, a1);
		planets.add(p1);

		Planet p2 = new Planet("Bulbasaur", "This planet vulnerable to Fire, Flying, Ice and Psychic moves.", puzzle2, a2);
		planets.add(p2);
		
		Planet p3 = new Planet("Vulpix", "This planet is vulnerable to Ground, Rock and Water moves.", puzzle3, a3);
		planets.add(p3);

	}

}
