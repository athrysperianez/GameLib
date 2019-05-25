import java.io.Serializable;

import javafx.util.Pair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/*
 *Creado por Elias Periañez
 *29 ene. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *29 ene. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public class Game implements Serializable {

	private static final long serialVersionUID = -6117728161169835564L;

	/**
	 * @author Elias Periañez This variable defines if you are playing a
	 *         singleplayer or a multiplayer game
	 */
	private GameType gameType;

	/**
	 * @author Elias Periañez The table is the field where your game happens
	 */
	private Section[][] table;

	/**
	 * @author Elias Periañez Used Pair to represent the 2 possible players and
	 *         their respective turns, when in a singleplayer game second turn will
	 *         always be null, if gameType is changed to multiplayer after the game
	 *         has been instantiated the second turn will be an empty Turn
	 */
	private Pair<Turn, Turn> turns;

	/**
	 * @author Elias Periañez The menu is the game menu, it will be use for starting
	 *         the game and for anything that requieres printing on the
	 *         screen/interact with the user, acting similar as the view on a MVC
	 *         logic.
	 */
	public Menu menu;

	public Game() {
	}

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

	public boolean startGame() {
		boolean result = true;
		try {
			boolean tick = true;
			while (!checkGameEnded()) {
				if (tick) {
					this.turns.getKey().onCall(this.menu);
				} else {
					this.turns.getValue().onCall(this.menu);
				}
				tick = !tick;
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public boolean checkGameEnded() {
		throw new NotImplementedException();
	}

	@Override
	public String toString() {
		return new StringBuffer(" Table : ").append(this.table.toString()).append(" Turns : ")
				.append(this.turns.toString()).append(" Game Type : ").append(this.gameType.toString())
				.append(" Menu : ").append(this.menu.toString()).toString();
	}
}

enum GameType {
	SINGLEPLAYER, MULTIPLAYER
}
