import javafx.util.Pair;

/*
 *Creado por Elias Peria�ez
 *29 ene. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (M�s informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Peria�ez
 *29 ene. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public class Game {
	
	/**
	 * @author Elias Peria�ez
	 * The table is the field where your game happens
	 */
	private Section [][] table;
	
	/**
	 * @author Elias Peria�ez
	 * Used Pair to represent the 2 possible players and their respective turns
	 */
	private Pair<Turn, Turn> turn;

	/**
	 * @author Elias Peria�ez
	 * The menu is the game menu, it will be use for starting the game and for anything that requieres printing on the screen/interact with the user, acting similar as the view on a MVC logic.
	 */
	public Menu menu;
	
}
