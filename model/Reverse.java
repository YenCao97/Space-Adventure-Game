package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

/**
 * The Reserve class is about the game that the player re-enters backwards 3 words shown
 */
public class Reverse extends Puzzle {
	
	//Attribute
	static ArrayList<String> datenBank = new ArrayList<String>();
	public String name;
	
	//Getter & Setter
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
	 * Call out the method game "Reverse"
	 * 
	 * @return false, if the game is not solved yet and vice versa
	 */
	@Override
	public boolean attemptPuzzle() {
		return reverse();
	}

	/**
	  * Get randomly 1 text from word list and then add to a String
	  * Set time for player input within 30 seconds
	  * Compare the user input to result of the game
	  * If the player's input is the same of the result, the player wins
	  *
	  * @return false, if the game is not solved yet and vice versa
	  */
	public static boolean reverse() {
			Scanner scan = new Scanner(System.in);
			datenBank();
			getRandomElement(datenBank);

			String text1 = getRandomElement(datenBank);
			String text2 = getRandomElement(datenBank);
			String text3 = getRandomElement(datenBank);
			String text = text1 + " " + text2 + " " + text3;

			StringBuilder input1 = new StringBuilder();
			input1.append(text1);
			input1.reverse();
			StringBuilder input2 = new StringBuilder();
			input2.append(text2);
			input2.reverse();
			StringBuilder input3 = new StringBuilder();
			input3.append(text3);
			input3.reverse();
			String input = input1.toString() + " " + input2.toString() + " " + input3.toString();
			System.out.println(text);
			System.out.println("Enter the answer within 30 seconds:");
			long startTime = System.currentTimeMillis();
		
			String userAnwser = scan.nextLine();
			String reverseResult;
			
			if (userAnwser.equals(input)) {
				reverseResult = "correct";
				puzzleSolve = true;
				
			} else {
				reverseResult = "wrong";
			} 
			long estimatedTime = System.currentTimeMillis() - startTime;
			if(estimatedTime <= 30000 && reverseResult.equalsIgnoreCase("correct")) {
				System.out.println("\nHerzlichen Glückwunsch! Sie haben gewonnen!");
				System.out.println("Das Rätsel ist gelöst. Sie können das Artefakt aufheben.\n");
				puzzleSolve = true;
				
			} else {
				System.out.println("Tut mir leid! Sie haben verloren!");
				System.out.println("Ihr Raumschiff verliert 1 Energiepunkt!\n");
				
			}
		return puzzleSolve;
	}

	/**
	    * Get randomly 1 text from word list 
	    * @param datenBank the array list to contain words
	    * @return the result of the value of word
	    */
	public static String getRandomElement(ArrayList<String> datenBank) {
		Random rand = new Random();
		return datenBank.get(rand.nextInt(datenBank.size()));
	}
	
	/**
	    * Create a arraylist to contain words
	    */
	public static void datenBank() {
		String d1 = "yrucreM";
		datenBank.add(d1);
		String d2 = "suneV";
		datenBank.add(d2);
		String d3 = "htraE";
		datenBank.add(d3);
		String d4 = "sraM";
		datenBank.add(d4);
		String d5 = "retipuJ";
		datenBank.add(d5);
		String d6 = "nrutaS";
		datenBank.add(d6);
		String d7 = "sunarU";
		datenBank.add(d7);
		String d8 = "enutpeN";
		datenBank.add(d8);
		String d9 = "otulP";
		datenBank.add(d9);
		String d10 = "nooM";
		datenBank.add(d10);
	}	
}