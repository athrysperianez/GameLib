package gameLib.main;

import java.io.Serializable;

import javafx.util.Pair;

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

	private String gameTitle;

	/**
	 * This variable defines if you are playing a singleplayer or a multiplayer game
	 */
	private GameType gameType;

	/**
	 * The table is the field where your game happens
	 */
	private Section[][] table;

	/**
	 * Used Pair to represent the 2 possible players and their respective turns,
	 * when in a singleplayer game second turn will always be null, if gameType is
	 * changed to multiplayer after the game has been instantiated the second turn
	 * will be an empty Turn
	 */
	private Pair<Turn, Turn> turns;

	// TODO Game javadoc
	public Game() {
	}

	public Game(String title, Section[][] table, Pair<Turn, Turn> turns, Menu menu) {
		this.gameTitle = title;
		this.table = table;
		this.turns = turns;
		this.gameType = GameType.MULTIPLAYER;
	}

	public Game(String title, Section[][] table, Turn turn, Menu menu) {
		this.gameTitle = title;
		this.table = table;
		this.turns = new Pair<Turn, Turn>(turn, null);
		this.gameType = GameType.MULTIPLAYER;
	}

	public boolean startGame(GameEndChecker check, Menu menu) {
		boolean result = true;
		try {
			boolean tic = true;
			Turn gmEnd = check.checkGameEnded(this);
			while (gmEnd == null) {
				if (tic) {
					this.turns.getKey().onCall(menu);
				} else {
					this.turns.getValue().onCall(menu);
				}

				tic = !tic;
				gmEnd = check.checkGameEnded(this);
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public String formatTable() {
		String result = "";
		for (Section section : this.table[0]) {
			result += "[" + section.getUnitOnIt().getSummary() + "]";
		}

		for (Section section : this.table[1]) {
			result += "[" + section.getUnitOnIt().getSummary() + "]";
		}
		return result;
	}

	@Override
	public String toString() {
		return new StringBuffer(" Table : ").append(this.table.toString()).append(" Turns : ")
				.append(this.turns.toString()).append(" Game Type : ").append(this.gameType.toString()).toString();
	}

	// Getters and setters
	public Section[][] getTable() {
		return table;
	}

	public void setTable(Section[][] table) {
		this.table = table;
	}

	public Pair<Turn, Turn> getTurns() {
		return turns;
	}

	public void setTurns(Pair<Turn, Turn> turns) {
		this.turns = turns;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public void setGameType(GameType gt) {
		this.gameType = gt;
	}

	public GameType getGameType() {
		return this.gameType;
	}

}

enum GameType {
	SINGLEPLAYER, MULTIPLAYER
}
