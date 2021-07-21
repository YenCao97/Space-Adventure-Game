package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.Random;

/**
 * The Puzzle class is about game that player has to solve
 * A puzzle has its name, description and puzzleSoled
 */
public class Puzzle {
	// Attribute
	public static String name;
	public static String puzzleDescription;
	public static boolean puzzleSolve = false;
	
	// Setter & Getter
	/**
	 * @return the Name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the Name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the puzzleDescription
	 */
	public String getPuzzleDescription() {
		return puzzleDescription;
	}
	/**
	 * @param puzzleDescription the puzzleDescription to set
	 */
	public void setPuzzleDescription(String puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
	}
	/**
	 * @return the puzzleSolve
	 */
	public boolean isPuzzleSolve() {
		return puzzleSolve;
	}
	/**
	 * @param puzzleSolve the puzzleSolve to set
	 */
	public void setPuzzleSolve(boolean puzzleSolve) {
		this.puzzleSolve = puzzleSolve;
	}
	
	// Operation

	/**
	 * Get the status of game
	 * 
	 * @return false, if the game is not solved yet and vice versa
	 */
	public boolean attemptPuzzle() {
		return false;
	}

}
