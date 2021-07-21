package de.htwberlin.prog1.sose21.spaceadventure.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The ListSpaceShip class is about a list containing of element SpaceShip
 */
public class ListSpaceShip {

	// Attribute
	private static ArrayList<SpaceShip> listSpaceShip;

	// Constructor
	/**
	 * Initialize listSpaceShip by ArrayList
	 */
	public ListSpaceShip() {
		this.listSpaceShip = new ArrayList<SpaceShip>();
	}

	// Getter & Setter
	/**
	 * @return the listSpaceShip
	 */
	public ArrayList<SpaceShip> getListSpaceShip() {
		return listSpaceShip;
	}

	/**
	 * @param listSpaceShip the listSpaceShip to set
	 */
	public void setListSpaceShip(ArrayList<SpaceShip> listSpaceShip) {
		this.listSpaceShip = listSpaceShip;
	}

	// Operations
	/**
	 * Add object SpaceShip to listSpaceShip
	 * @param sp SpaceShip object
	 */
	public void addSpaceShip(SpaceShip sp) {
		listSpaceShip.add(sp);
	}
	/**
	 * Print each SpaceShip of listSpaceShip on the console
	 */
	public void printListSP() {
		for (SpaceShip sp : listSpaceShip) {
			if (sp != null) {
				sp.print();
			}
		}
	}
	/**
	 * Delete object SpaceShip from listSpaceShip by Ship's name
	 */
	public void deleteSpaceShip() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of ship you want delete: ");
		String nameInput = scan.nextLine();
		for (SpaceShip sp : listSpaceShip) {
			if (sp.getShipName().equalsIgnoreCase(nameInput)) {
				listSpaceShip.remove(sp);
			}
		}
	}
}
