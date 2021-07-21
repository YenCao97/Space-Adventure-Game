package de.htwberlin.prog1.sose2021.spaceadventure.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import de.htwberlin.prog1.sose21.spaceadventure.model.ListSpaceShip;
import de.htwberlin.prog1.sose21.spaceadventure.model.Planet;
import de.htwberlin.prog1.sose21.spaceadventure.model.Puzzle;
import de.htwberlin.prog1.sose21.spaceadventure.model.SpaceShip;
import jdk.swing.interop.SwingInterOpUtils;
/**
 * 
 * @author yencao
 * 
 */

/**
 * The SpaceAdventureApp class contains main class and shows all Menus of game SpaceAdventure
 */
public class SpaceAdventureApp {
	//Attribute
	
	private static SpaceAdventureGame spaceAdventureGame;
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<SpaceShip> listSpaceShip = new ArrayList<SpaceShip>();
	private static SpaceShip spaceShip;
	private static int indexSpaceShip = -1;
	private static int indexPlanet = -1;

	/**
	 * @param args main class
	 */
	public static void main(String[] args) {
		spaceAdventureGame.showPlanet();
		handle();
		System.out.println("======================================================");
	}
	
	//Operations
	/**
	 * Read player's input
	 * @return player's input
	 */
	private static String readUserInput() {
		System.out.print("\nWas moechten Sie tun? Waehlen Sie einen Buchstaben: ");
		String choiceInternal = scan.next();
		return choiceInternal;
	}

	/**
	 * Handle player's input in Main menu
	 */
	private static void handle() {
		boolean flag = true;
		do {
			showMenu();
			System.out.println("\nWas moechten Sie tun? Waehlen Sie einen Buchstaben:\t");
			String choice = scan.next();
			switch (choice) {
			case "R":
				createSpaceShip();
				break;
			case "C":
				chooseSpaceShip();
				break;
			case "A":
				showSpaceShip();
				break;
			case "S":
				saveSpaceShip();
				break;
			case "L":
				deleteSpaceShip();
				break;
			case "W":
				showAdventureMenu();
				break;
			case "B":
				flag = false;
				break;
			default: {
				System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
				showMenu();
			}
				break;
			}
		} while (flag);
	}

	/**
	 * Show Main menu on the console
	 */
	private static void showMenu() {
		String menuItems[] = { "", "R\t <R>aumschiff erstellen", "C\t Raums<c>hiff auswählen",
				"A\t Daten aller Raumschiffe <a>usgeben", "S\t Raumschiff <s>peichern", "L\t Raumschiff <l>öschen",
				"W\t <W>eltraumabenteuer beginnen", "B\t <B>eenden" };

		System.out.println("\n----------- Space Adventure 1.0 -----------\n");
		System.out.println("\nWillkommen zum SuperStarGalaktika 4997 Spiel ...\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}
	}

	/**
	 * Create SpaceShip by player's input
	 */
	private static void createSpaceShip() {
		spaceShip = new SpaceShip();
		spaceShip.inputShip();
		spaceShip.print();
	}

	/**
	 * There are min. 2 available SpaceShips and player chooses SpaceShip they want to use by entering ship's name
	 */
	private static void chooseSpaceShip() {
		if (listSpaceShip.size() >= 2) {
			System.out.println("Bitte waehlen Sie ein SpaceShip.");
			for (SpaceShip sp : listSpaceShip) {
				System.out.println(sp.getShipName());
			}
			//System.out.print("Geben Sie Name von SpaceShip: ");
			boolean checkInputSpaceShip = false;
			do {
				System.out.print("Geben Sie Name von SpaceShip: ");
				String inputName = scan.next();

				for (int i = 0; i < listSpaceShip.size(); i++) {
					if (listSpaceShip.get(i).getShipName().equalsIgnoreCase(inputName)) {
						indexSpaceShip = i;
						checkInputSpaceShip = true;
						System.out
								.println("Sie haben " + listSpaceShip.get(indexSpaceShip).getShipName() + " ausgewaehlen.");
					}
				}
			} while (!checkInputSpaceShip);
		} else {
			System.out.println(
					"Sie haben noch kein SpaceShip ausgewaehlt oder Es gibt nicht genug SpaceShip Adventure zu starten");
		}
	}

	/**
	 * Show all SpaceShip in the ListSpaceShip
	 */	
	private static void showSpaceShip() {
		System.out.println("Die Liste von erstellten SpaceShip \n");
		for (SpaceShip sp : listSpaceShip) {
			if (sp != null) {
				sp.print();
			}
		}
	}

	/**
	 *  Add SpaceShip to the ListSpaceShip
	 */	
	private static void saveSpaceShip() {
		listSpaceShip.add(spaceShip);
		System.out.println("Dein SpaceShip wurde gespeichert");
	}

	/**
	 * Delete SpaceShip from the ListSpaceShip by ship's name
	 */
	private static void deleteSpaceShip() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Geben Sie den Namen des Schiffs ein, das Sie löschen möchten: ");
		String nameInput = scan.next();
		for (SpaceShip sp : listSpaceShip) {
			if (sp.getShipName().equalsIgnoreCase(nameInput)) {
				listSpaceShip.remove(sp);
			}
		}
		System.out.println("Das SpaceShip wurde geloescht");
	}

	/**
	 * Finish the game Adventure
	 */
	private static void finishGame() {
		System.out.println("AdventureGame wird beendet.");
	}

	/**
	 * Handle player's input on AdventureGame menu
	 */
	private static void handleAdventure() {
		String inputAdventure = scan.next();
		switch (inputAdventure) {
		case "P":
			for (int i = 0; i < 3; i++) {
				choosePlanet();
			}
			break;
		case "T":
			randomPlanet();
			showAdventureMenu();
			break;
		case "D":
			showMenu();
			break;

		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			showAdventureMenu();
		}
			break;
		}
	}

	/**
	 * Print AdventureGame on the console
	 */
	private static void printAdventureMenu() {
		System.out.println("\n----------------------\n");
		System.out.println("----------Adventure Menu ----------");
		String menuAdventure[] = { "", "P\t Planeten anfliegen", "T\t Treiben lassen",
				"D\t Weltraumabenteuer beenden" };
		for (int i = 1; i < menuAdventure.length; i++) {
			System.out.println(menuAdventure[i]);
		}
		System.out.print("\nWas moechten Sie tun? Waehlen Sie einen Buchstaben:\t");
	}

	/**
	 * Player must choose a SpaceShip firtst and starts AdventureGame
	 */
	private static void showAdventureMenu() {
		if (indexSpaceShip == -1) {
			System.out.println("Bitte waehlen Sie zuerst ein SpaceShip aus");
		} else {
			System.out.println("Die Abendteure startet jetzt");
			printAdventureMenu();
			handleAdventure();
		}
	}

	/**
	 * Player choose a destination of AdventureGame
	 */
	public static void choosePlanet() {
		System.out.println(
				"\nDein Raumschiff ist abgehoben. Du schaust auf Deine Karte und findest die folgenden Planeten auf Deiner Karte:\n");
		for (int i = 0; i < spaceAdventureGame.planets.size(); i++) {
			System.out.println(spaceAdventureGame.planets.get(i).getPlanetName());
		}
		System.out.println("\n");
		System.out.print("\nWohin moechten Sie fliegen? Geben Sie Name von Planet: ");	
		String inputPlanet = scan.next();
		int countExperiencePoint = 0;

		for (int i = 0; i < spaceAdventureGame.planets.size(); i++) {
			if (spaceAdventureGame.planets.get(i).getPlanetName().equalsIgnoreCase(inputPlanet)) {
				System.out.println(
						"Sie haben Planet " + spaceAdventureGame.planets.get(i).getPlanetName() + " ausgewaehlt.");
				boolean result = spaceAdventureGame.planets.get(i).getPuzzle().attemptPuzzle();
				if (result == true) {
					countExperiencePoint = listSpaceShip.get(indexSpaceShip).getFlagExperience();
					countExperiencePoint += 1;
					listSpaceShip.get(indexSpaceShip).setFlagExperience(countExperiencePoint);
				} else {
					int energyPoint = listSpaceShip.get(indexSpaceShip).getShipEnergy();
					energyPoint -= 1;
					listSpaceShip.get(indexSpaceShip).setShipEnergy(energyPoint);
					System.out.println("Ihr SpaceShip hat noch " + energyPoint + " Energy Punkte");			
				}

				if (listSpaceShip.get(indexSpaceShip).getShipEnergy() == 0) {
					listSpaceShip.get(indexSpaceShip).setShipExists(false);
					listSpaceShip.remove(indexSpaceShip);
					System.out.println("Ihr SpaceShip existiert nicht.");			
				}
				
				int endExperiencePoint = listSpaceShip.get(indexSpaceShip).getFlagExperience() / 3;
				listSpaceShip.get(indexSpaceShip).setShipExperience(endExperiencePoint);
				System.out.println("Ihr SpaceShip hat " + listSpaceShip.get(indexSpaceShip).getShipExperience()
						+ " Experience Punkt(e)");
			}
		}
	}

	/**
	 * Player let the SpaceShip drift in the space
	 */
	public static void randomPlanet() {
		int countExperiencePoint = 0;
		Collections.shuffle(spaceAdventureGame.planets);
		for (int i = 0; i < spaceAdventureGame.planets.size(); i++) {
			System.out.println("Sie haben nach " + spaceAdventureGame.planets.get(i).getPlanetName() + " geflogen");
			System.out.println("\n");
			boolean result = spaceAdventureGame.planets.get(i).getPuzzle().attemptPuzzle();
			if (result == true) {
				countExperiencePoint = listSpaceShip.get(indexSpaceShip).getFlagExperience();
				countExperiencePoint += 1;
				listSpaceShip.get(indexSpaceShip).setFlagExperience(countExperiencePoint);
			} else {
				int energyPoint = listSpaceShip.get(indexSpaceShip).getShipEnergy();
				energyPoint -= 1;
				listSpaceShip.get(indexSpaceShip).setShipEnergy(energyPoint);
				System.out.println("Ihr SpaceShip hat noch " + energyPoint + " Energy Punkte");			
			}

			if (listSpaceShip.get(indexSpaceShip).getShipEnergy() == 0) {
				listSpaceShip.get(indexSpaceShip).setShipExists(false);
				listSpaceShip.remove(indexSpaceShip);
				System.out.println("Ihr SpaceShip existiert nicht.");			
			}
			
			int endExperiencePoint = listSpaceShip.get(indexSpaceShip).getFlagExperience() / 3;
			listSpaceShip.get(indexSpaceShip).setShipExperience(endExperiencePoint);
			System.out.println("Ihr SpaceShip hat " + listSpaceShip.get(indexSpaceShip).getShipExperience()
					+ " Experience Punkt(e)");		
		}
	}
}
