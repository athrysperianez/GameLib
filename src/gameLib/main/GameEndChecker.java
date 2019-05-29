package gameLib.main;

/*
 *Creado por Elias Periañez
 *27 may. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *27 may. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public interface GameEndChecker {
	/**
	 * This function will be called before a new turn start.
	 * @param gm The game to be checked
	 * @return Returns true if the game have to end, return false if not
	 */
	public Turn checkGameEnded(Game gm);
}
