/*
 *Creado por Elias Peria�ez
 *31 ene. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (M�s informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Peria�ez
 *31 ene. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

abstract public class Turn {

	/**
	 * @author Elias Peria�ez
	 * All the actions that can be done in this turn
	 */
	private Action [] possibleActions;
	
	/**
	 * @author Elias Peria�ez
	 * @param <strong> possibleActions: </strong> All the actions that can be done in this turn
	 */
	Turn(Action [] possibleActions){
		this.possibleActions = possibleActions;
	}
	
	public void start(Game game) {
		game.menu.choiceMenu(this.filterCurrentActions(game));
	}
	
	/**
	 * 
	 * @param <strong> game: </strong> The game object, use it to find out the current state of the game and filter
	 * @return An array list of possible actions in the current state of the game, by default every action is considered as possible so it will return possibleActions param.
	 * Use this method to check possible actions for the current turn
	 */
	private Action[] filterCurrentActions(Game game) {
		return this.possibleActions;
	}
	
}