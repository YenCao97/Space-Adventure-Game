package de.htwberlin.prog1.sose21.spaceadventure.model;

/**
 * The Planet class is about planet
 * A planet has its ID, name, description, creature, puzzle and artefact
 */
public class Planet {
	
	// Attribute
	private String planetId;
	private String planetName;
	private String planetDescription;
	private String planetCreature;
	private Puzzle puzzle;
	private Artefact artefact;
	
	// Constructor
	/**
	 * Initialize object Planet by name, description, puzzle and artefact
	 * @param name name of planet
	 * @param description describe about planet
	 * @param puzzle type of game
	 * @param artefact artefact that player picks up after solving a game
	 */
	public Planet(String name, String description, Puzzle puzzle, Artefact artefact) {
		this.planetName = name;
		this.planetDescription = description;
		this.puzzle = puzzle;
		this.artefact = artefact;
	}
	
	// Getter & Setter
	/**
	 * @return the planetCreature
	 */
	public String getPlanetCreature() {
		return planetCreature;
	}

	/**
	 * @param planetCreature the planetCreature to set
	 */
	public void setPlanetCreature(String planetCreature) {
		this.planetCreature = planetCreature;
	}

	/**
	 * @return the puzzle
	 */
	public Puzzle getPuzzle() {
		return puzzle;
	}

	/**
	 * @param puzzle the puzzle to set
	 */
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	/**
	 * @return the artefact
	 */
	public Artefact getArtefact() {
		return artefact;
	}

	/**
	 * @param artefact the artefact to set
	 */
	public void setArtefact(Artefact artefact) {
		this.artefact = artefact;
	}

	/**
	 * @return the planetId
	 */
	public String getPlanetId() {
		return planetId;
	}

	/**
	 * @return the planetName
	 */
	public String getPlanetName() {
		return planetName;
	}

	/**
	 * @return the planetDescription
	 */
	public String getPlanetDescription() {
		return planetDescription;
	}
	
	// Operation
	/**
	 * Get the type of game
	 * 
	 */
	public void attemptPuzzle() {
		
	}
}
