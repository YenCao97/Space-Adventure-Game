package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * The CountSrings class is about the game that player counts the occurrences of
 * String "tam"
 */
public class CountStrings extends Puzzle {

	// Attribute
	private String name;

	// Setter & Getter
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Operations

	/**
	 * Call out the method game "CountStrings"
	 * 
	 * @return false, if the game is not solved yet and vice versa
	 */
	@Override
	public boolean attemptPuzzle() {
		return countStrings();
	}

	/**
	 * Ramdom the number of occurences of String "tam" between 0 and 15 and then add
	 * n times of "tam to ArrayList "listTam". Ramdom the number of occurences of
	 * String "rex" between 0 and 3 and then add n times of "rex" to ArrayList
	 * "listRex" and within ArrayList "listTam". Set time for player entering answer
	 * within 20 seconds. Compare the player input to result of the game. If the
	 * player's input is the same of the occurences of "tam", the player wins.
	 * 
	 * @return the result of the game: solved or not
	 */
	public static boolean countStrings() {
		try {
			// Add elements to each substrings
			Scanner scan = new Scanner(System.in);
			String tam = "tam";
			ArrayList<String> listTam = new ArrayList<String>();
			ArrayList<String> listRex = new ArrayList<String>();
			Random rand = new Random();
			int xtam = rand.nextInt(15);
			String countResult = "";
			for (int i = 0; i < xtam; i++) {
				listTam.add(tam);
				int xrex = rand.nextInt(3);
				if (xrex == 0) {
					listRex.add("");
				} else if (xrex == 1) {
					listRex.add("rex");
				} else if (xrex == 2) {
					listRex.add("rexrex");
				}
			}
			// Combine 2 substrings to 1 string
			String finalString = "";
			for (int i = 0; i < xtam; i++) {
				finalString += listTam.get(i);
				finalString += listRex.get(i);
			}
			System.out.println("\nString: " + finalString);
			System.out
					.print("\nZählen Sie die Vorkommen von \"tam\" und geben Sie die Antwort innerhalb von 20 Sekunden ein:");

			// Set time for input
			long startTime = System.currentTimeMillis();
			int userAnswser = scan.nextInt();
			if (userAnswser == xtam) {
				countResult = "correct";
				puzzleSolve = true;
			} else {
				countResult = "wrong";
			}
			long estimatedTime = System.currentTimeMillis() - startTime;
			if (estimatedTime <= 20000 && countResult.equalsIgnoreCase("correct")) {
				System.out.println("\nHerzlichen Glückwunsch! Sie haben gewonnen!");
				System.out.println("Das Rätsel ist gelöst. Sie können das Artefakt aufheben.\n");
				puzzleSolve = true;
			} else {
				System.out.println("Tut mir leid! Sie haben verloren!");
				System.out.println("Ihr Raumschiff verliert 1 Energiepunkt!\n");
			}
		}catch(InputMismatchException ie) {
			System.out.println("InputMismatchException!");
		}
		return puzzleSolve;
	}
}
