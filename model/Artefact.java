package de.htwberlin.prog1.sose21.spaceadventure.model;

/**
 * The Artefact class is about the artifact player gets for solving the puzzle
 * A Artefact has its name and descriptipn
 */
public class Artefact {
	
	// Attribute
	private String artefactName;
	private String artefactDescription;
	
	// Constructor
	/**
	 * Initialize Artefact object by artefactName and artefactDescription
	 * @param artefactName name of artefact
	 * @param artefactDescription describe about artefact
	 */
	public Artefact(String artefactName, String artefactDescription) {
		this.artefactName = artefactName;
		this.artefactDescription = artefactDescription;
	}

	// Getter & Setter
	/**
	 * @return the artefactName
	 */
	public String getArtefactName() {
		return artefactName;
	}

	/**
	 * @param artefactName the artefactName to set
	 */
	public void setArtefactName(String artefactName) {
		this.artefactName = artefactName;
	}

	/**
	 * @return the artefactDescription
	 */
	public String getArtefactDescription() {
		return artefactDescription;
	}

	/**
	 * @param artefactDescription the artefactDescription to set
	 */
	public void setArtefactDescription(String artefactDescription) {
		this.artefactDescription = artefactDescription;
	}

}
