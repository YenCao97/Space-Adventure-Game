package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The SpaceShip class is about spaceship.
 * A spaceship has its ID, name, description, age, energy point, experience point and Exits
 */
public class SpaceShip {

	// Attribute
	private String shipId = UUID.randomUUID().toString();
	private String shipName;
	private String shipDescription;
	private int shipAge;
	private int shipEnergy = 3;
	private int shipExperience = 0;
	private int flagExperience = 0;
	private boolean shipExists = true;
	private ArrayList<Artefact> artefacts = new ArrayList<Artefact>();

	// Construction
	/**
	 * Initialize object SpaceShip by name, description and age
	 * 
	 * @param name name of SpaceShip
	 * @param description description about SpaceShip
	 * @param age age of SpaceShip
	 */
	public SpaceShip(String name, String description, int age) {
		this.shipName = name;
		this.shipDescription = description;
		this.shipAge = age;
	}
	
	/**
	 * Initialize object SpaceShip
	 * 
	 */
	public SpaceShip() {
		
	}

	//Getter & Setter
	
	/**
	 * @return the flagExperience
	 */
	public int getFlagExperience() {
		return flagExperience;
	}

	/**
	 * @param flagExperience the flagExperience to set
	 */
	public void setFlagExperience(int flagExperience) {
		this.flagExperience = flagExperience;
	}

	/**
	 * @return the shipName
	 */
	public String getShipName() {
		return shipName;
	}

	/**
	 * @return the shipDescription
	 */
	public String getShipDescription() {
		return shipDescription;
	}

	/**
	 * @return the shipAge
	 */
	public int getShipAge() {
		return shipAge;
	}

	/**
	 * @return the shipId
	 */
	public String getShipId() {
		return shipId;
	}

	/**
	 * @param shipEnergy the shipEnergy to set
	 */
	public void setShipEnergy(int shipEnergy) {
		this.shipEnergy = shipEnergy;
	}
	
	/**
	 * @return the shipEnergy
	 */
	public int getShipEnergy() {
		return shipEnergy;
	}

	/**
	 * @param shipExperience the shipExperience to set
	 */
	public void setShipExperience(int shipExperience) {
		this.shipExperience = shipExperience;
	}
	
	/**
	 * @return the shipExperience
	 */
	public int getShipExperience() {
		return shipExperience;
	}

	/**
	 * @param shipExists the shipExists to set
	 */
	public void setShipExists(boolean shipExists) {
		this.shipExists = shipExists;
	}

	/**
	 * @return the shipExists
	 */
	public boolean isShipExists() {
		return shipExists;
	}

	// Operation
	/**
	 * Get input of user about SpaceShip
	 */
	public void inputShip() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please anwser following questions");
			System.out.print("Enter ship's name: ");
			this.shipName = scan.nextLine();
			System.out.print("Write a description for your ship: ");
			this.shipDescription = scan.nextLine();
			System.out.print("Enter ship's age: ");
			this.shipAge = scan.nextInt();
		}catch(InputMismatchException ie) {
			System.out.println("InputMismatchException!");
		}
	}
	
	/**
	 * Check status of SpaceShip
	 * @param shipEnergy energy points of SpaceShip
	 * @return true, if SpaceShip has energy points more than 0
	 */
	public boolean checkExist(int shipEnergy) {
		if (shipEnergy > 0) {
			shipExists = true;
		}
		return shipExists;
	}
	/**
	 * Print attributes of SpaceShip on the console
	 * 
	 */
	public void print() {
		System.out.println("ID: " + getShipId());
		System.out.println("Name: " + getShipName());
		System.out.println("Age: " + getShipAge());
		System.out.println("Description: " + getShipDescription());
		System.out.println("Energy: " + getShipEnergy());
		System.out.println("Experence points:" + getShipExperience() + "\n");
		checkExist(shipEnergy);
		if (shipExists) {
			System.out.println("The ship exists");
		} else {
			System.out.println("The ship does not exist");
		}
		System.out.println("");
	}
}
