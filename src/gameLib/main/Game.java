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

	private boolean debug = true;

	// TODO Game javadoc
	public Game() {
	}

	public Game(String title, Section[][] table, Pair<Turn, Turn> turns, Menu menu) {
		this.gameTitle = title;
		this.table = table;
		this.turns = turns;
		this.gameType = GameType.MULTIPLAYER;
	}

	public Game(String title, Section[][] table, Turn turn) {
		this.gameTitle = title;
		this.table = table;
		this.turns = new Pair<Turn, Turn>(turn, null);
		this.gameType = GameType.SINGLEPLAYER;
	}

	public Game(String title, Section[][] table, Pair<Turn, Turn> turns, GameType gmType) {
		this.gameTitle = title;
		this.table = table;
		this.turns = turns;
		this.gameType = gmType;
	}

	public void startMenuExecute(Menu startMenu) {
		System.err.print(this.debug
				? "The function startMenuExecute is defaulted right now, override it in a local game class or disable the debug mode using setDebugMode(false)\n"
				: "");
	}

	public boolean startGame(GameEndChecker check, Menu startMenu, boolean printTable) {
		System.err.print(this.debug
				? "Watch out, debug mode is on, you will se messages such as this, if you think you shouldn´t be seeing this, please contact the game creator\n"
				: "");
		if (startMenu != null) {
			this.startMenuExecute(startMenu);
		} else {
			System.err.print(this.debug ? "Start menu is null\n" : "");
		}
		boolean result = true;
		try {
			boolean tic = true;
			Turn gmEnd = check.checkGameEnded(this);
			System.err.print(this.debug ? "First end checker returned " + gmEnd + "\n" : "");

			while (gmEnd == null) {
				if (printTable) {
					System.err.print(this.debug ? "Printing table\n" : "");
					System.out.println(this.formatTable());
				}
				if (tic) {
					System.err.print(this.debug ? "First turn called\n" : "");
					this.turns.getKey().onCall(this.table);
				} else {
					System.err.print(this.debug ? "Second turn called\n" : "");
					this.turns.getValue().onCall(this.table);
				}

				tic = !tic;
				gmEnd = check.checkGameEnded(this);
				System.err.print(this.debug ? "End checker returned " + gmEnd + "\n" : "");
			}
			System.err.print(this.debug ? "Game ended\n" : "");
		} catch (Exception e) {
			result = false;
			if (this.debug) {
				System.err.print("Exception on game loop\n");
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean startGame(GameEndChecker check, boolean printTable) {
		return this.startGame(check, null, printTable);
	}

	public boolean startGame(GameEndChecker check, Menu startMenu, boolean printTable, Updater update) {
		System.err.print(this.debug
				? "Watch out, debug mode is on, you will se messages such as this, if you think you shouldn´t be seeing this, please contact the game creator\n"
				: "");
		boolean result = true;
		System.out.println("Imprimiendo tabla");
		if (startMenu != null) {
			this.startMenuExecute(startMenu);
		}
		try {
			boolean tic = true;
			Turn gmEnd = check.checkGameEnded(this);
			System.err.print(this.debug ? "First end checker returned " + gmEnd + "\n" : "");
			while (gmEnd == null) {
				System.err.print(this.debug ? "First turn updater called\n" : "");
				update.update(this.turns.getKey(), this);
				System.err.print(this.debug ? "Second turn updater called\n" : "");
				update.update(this.turns.getValue(), this);
				if (printTable) {
					System.err.print(this.debug ? "Printing table\n" : "");
					System.out.println(this.formatTable());
				}
				if (tic) {
					System.err.print(this.debug ? "First turn called\n" : "");
					this.turns.getKey().onCall(this.table);
				} else {
					System.err.print(this.debug ? "Second turn called\n" : "");
					this.turns.getValue().onCall(this.table);
				}
				tic = !tic;
				gmEnd = check.checkGameEnded(this);
				System.err.print(this.debug ? "End checker returned " + gmEnd + "\n" : "");

			}
		} catch (Exception e) {
			result = false;
			if (this.debug) {
				System.err.print("Exception on game loop\n");
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean startGame(GameEndChecker check, boolean printTable, Updater update) {
		return this.startGame(check, null, printTable, update);
	}

	public String formatTable() {
		String result = "";
		for (int i = 0; i < this.table.length - 1; i++) {
			result += this.debug ? i : "";
			for (Section section : this.table[i]) {
				if (section.getUnitOnIt() == null) {
					result += "[]";
				} else {
					result += "[" + section.getUnitOnIt().getSummary() + "]";
				}
			}
			result += "\n";
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

}
