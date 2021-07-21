
package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The Tictactoe class is about the game that the player plays TicTacToe with the computer
 */
public class TicTacToe extends Puzzle {

	// Attribute
	public String name;
	public static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	public static ArrayList<Integer> computerPositions = new ArrayList<Integer>();
	
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

// Operation

	/**
	 * Call out the methode game "TicTacToe"
	 * 
	 * @return false, if the game is not solved yet and vice versa
	 */
	@Override
	public boolean attemptPuzzle() {
		return tictactoe();
	}
	
	/**
	  * Create the board game
	  *
	  * @return game board of TicTacToe
	  */
	public static char[][] gameBoard() {
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };
		return gameBoard;
	}
	
	/**
	  * The player and computer take turns to place their move on the board game
	  * Sequences of moves are saved in ArrayList "playerPositions" and "computerPositions"
	  * Check the availability of each position of player and computer
	  * If a position is not available, the player must enter again
	  *
	  * @return the result of sequence of moves
	  */
	public static boolean tictactoe() {
		Scanner scan = new Scanner(System.in);
		char[][] gameBoard = gameBoard();
		printGameBoard(gameBoard);
		try {
			while (true) {
				System.out.println("Geben Sie eine Stelle für Ihren Zug ein (1-9): ");
				int playerPos = Integer.parseInt(scan.nextLine());
				while (playerPositions.contains(playerPos) || computerPositions.contains(playerPos)) {
					System.out.println("Ungültige Stelle! Geben Sie die Stelle erneut ein:");
					playerPos = Integer.parseInt(scan.nextLine());
				}
				String result = checkWinner();
				placeMove(gameBoard, playerPos, "player");
				result = checkWinner();
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
				Random rand = new Random();
				int comPos = rand.nextInt(9) + 1;
				while (playerPositions.contains(comPos) || computerPositions.contains(comPos)) {
					comPos = rand.nextInt(9) + 1;
				}
				placeMove(gameBoard, comPos, "computer");
				printGameBoard(gameBoard);
				result = checkWinner();
				
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
			}
		}catch(NumberFormatException ne) {
			System.out.println("NumberFormatException!");
		}
		return puzzleSolve;
	}
	
	/**
	  * Print the board game on the console
	  *
	  * @param gameBoard the array to display every its row and its column
	  */
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}

			System.out.println();
		}
	}
	
	/**
	  * Place moves of player and computer in the board game
	  *
	  * @param gameBoard the array to display index of the position on the board game
	  * @param pos the integer to display the position of move on the board game
	  * @param user the String to display play turn of player or computer
	  */
	public static void placeMove(char[][] gameBoard, int pos, String user) {
		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if (user.equals("computer")) {
			symbol = 'O';
			computerPositions.add(pos);
		}
		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	/**
	  * Create winning conditions by grouping of moves
	  *
	  * @return the result of the game: solved or not
	  */
	public static String checkWinner() {
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);

		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);

		for (List l : winning) {
			if (playerPositions.containsAll(l)) {
				puzzleSolve = true;
				char gameBoard[][] = gameBoard();
				return "\nHerzlichen Glückwunsch! Sie haben gewonnen!\nDas Rätsel ist gelöst. Sie können das Artefakt aufheben.";
			} else if (computerPositions.containsAll(l)) {
				char gameBoard[][] = gameBoard();
				return "Tut mir leid! Sie haben verloren!\nIhr Raumschiff verliert 1 Energiepunkt!";
			} else if (playerPositions.size() + computerPositions.size() == 9) {
				char gameBoard[][] = gameBoard();
				return "Das Spiel ging unentschieden aus.\nIhr Raumschiff verliert 1 Energiepunkt!\n";
			}
		}
		return "";
	}	
}
