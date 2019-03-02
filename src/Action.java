import javafx.util.Pair;

/*
 *Creado por Elias Periañez
 *31 ene. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *31 ene. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public interface Action {
	
	/**
	 * @author Elias Periañez
	 * This function will be called when the game wants to execute this action, define here what do you want this action to do, the table of the game will be passed as parameter
	 * @param <strong> Table: </strong> Is the current board of the game.
	 */
	public void onCall(Section [][] table);
	
	/**
	 * @author Elias Periañez
	 * This function will be called by the menu for knowing the name and info about the action, if you don´t want to give any info, u can put the second string to null
	 * @return A Pair object containing two strings, the first one with the name of the action (This one is obligatory) and the second one containing any info about the action (This one can be null)
	 */
	public Pair<String, String> getActionInfo();
}
