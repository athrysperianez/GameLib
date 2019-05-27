package gameLib.main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import gameLib.exceptions.NotImplementedException;

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

abstract public class Turn implements Serializable{


	private static final long serialVersionUID = -7901032368453232885L;
	/**
	 * @author Elias Periañez All the actions that can be done in this turn
	 */
	private Action[] possibleActions;
	
	private Unit[] turnUnits;

	/**
	 * @author Elias Periañez
	 * @param <strong>
	 *            possibleActions: </strong> All the actions that can be done in
	 *            this turn
	 */
	public Turn(Action[] possibleActions, Unit[] units) {
		this.setPossibleActions(possibleActions);
		this.turnUnits = units;
	}

	// TODO Javadoc
	public void onCall(Menu menu) {
		try {
			throw new NotImplementedException();
		} catch (NotImplementedException e) {
			e.printStackTrace();
			System.err.println("At lane: " + e.getStackTrace()[0].getLineNumber());
		}
	}

	/**
	 * @param <strong>
	 *            game: </strong> The game object, use it to find out the current
	 *            state of the game and filter
	 * @return An array list of possible actions in the current state of the game,
	 *         by default every action is considered as possible so it will return
	 *         possibleActions param. Use this method to check possible actions for
	 *         the current turn
	 */
	private Action[] filterCurrentActions(Game game) {
		ArrayList<Action> tmpPerUnitType = new ArrayList<Action>();
		Set<Action> tmpPerUnit = new HashSet<Action>();
		for (Unit u: turnUnits) {
			tmpPerUnit.addAll(Arrays.asList(u.getActionsPerUnit()));
			tmpPerUnitType.addAll(Arrays.asList(u.getActionsPerUnitType()));
		}
		ArrayList<Action> tmpPossibleActions = new ArrayList<Action>();
		tmpPossibleActions.addAll(tmpPerUnit);
		tmpPossibleActions.addAll(tmpPerUnitType);
		return (Action[]) tmpPossibleActions.toArray();
	}

	// TODO Javadoc
	public void onActionChoosed(Action action) {
		try {
			throw new NotImplementedException();
		} catch (NotImplementedException e) {
			e.printStackTrace();
			System.err.println("At lane: " + e.getStackTrace()[0].getLineNumber());
		}
	}

	public Unit[] getTurnUnits() {
		return turnUnits;
	}

	public void setTurnUnits(Unit[] turnUnits) {
		this.turnUnits = turnUnits;
	}

	public Action[] getPossibleActions() {
		return possibleActions;
	}

	public void setPossibleActions(Action[] possibleActions) {
		this.possibleActions = possibleActions;
	}

}
