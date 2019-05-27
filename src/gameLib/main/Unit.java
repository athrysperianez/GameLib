package gameLib.main;
import java.io.Serializable;

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

public interface Unit extends Serializable{
	
	/**
	 * @author Elias Periañez
	 * In this function you must return the actions that correspond to the unit and can be done for each unit in the game
	 */
	public Action[] getActionsPerUnit();

	/**
	 * @author Elias Periañez
	 * In this function you must return the actions that correspond to the unit and can be done once you have an unit of that type in the field and are not bound to the unit itself.
	 */
	public Action[] getActionsPerUnitType();
	
	/*
	 * You must implement this function in order for the save game function to work, check documentation to see how.
	 */
	@Override
	public String toString();
	
	/**
	 * @return Return the char that represent the unit
	 */
	public char getSummary();

}
