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
	 * This variable defines if you are playing a singleplayer or a multiplayer game
	 */
	private GameType gameType;
	
	/**
	 * @author Elias Peria�ez
	 * The table is the field where your game happens
	 */
	private Section [][] table;
	
	/**
	 * @author Elias Peria�ez
	 * Used Pair to represent the 2 possible players and their respective turns, when in a singleplayer game second turn will always be null, if gameType is changed to multiplayer 
	 * after the game has been instantiated the second turn will be an empty Turn
	 */
	private Pair<Turn, Turn> turns;

	/**
	 * @author Elias Peria�ez
	 * The menu is the game menu, it will be use for starting the game and for anything that requieres printing on the screen/interact with the user, acting similar as the view on a MVC logic.
	 */
	public Menu menu;
	
	
	public Game() {}
	
	public Game(Section[][] table, Pair<Turn, Turn> turns, Menu menu) {
		this.table = table;
		this.turns = turns;
		this.gameType = GameType.MULTIPLAYER;
		this.menu = menu;
	}
	
	public Game(Section[][] table, Turn turn, Menu menu) {
		this.table = table;
		this.turns = new Pair<Turn, Turn>(turn, null);
		this.gameType = GameType.MULTIPLAYER;
		this.menu = menu;
	}
	
	
	public boolean initialize() {
		Boolean result = true;
		try {
		/**
		 * TODO implements initialization code
		 */
		}catch (Exception e) {
			result = false;
		}
		return result;
	}
}

enum GameType{
	SINGLEPLAYER, MULTIPLAYER
}
