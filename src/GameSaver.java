import javafx.util.Pair;

/*
 *Creado por Elias Periañez
 *25 may. 2019
 *Como parte del proyecto GameLib
 *Este archivo esta bajo la licencia de Creative Commons Reconocimiento 4.0 Internacional (Más informacion https://creativecommons.org/licenses/by/4.0/)
________________________________________________________________________________________________________________________________________________________
 *Created by Elias Periañez
 *25 may. 2019
 *As part of the project GameLib
 *This file is under the Creative Commons Attribution 4.0 International (More info here https://creativecommons.org/licenses/by/4.0/)
 */

public class GameSaver {

	/**
	 * 
	 * @param game
	 * @return Return a pair with a boolean and a string, the boolean will be true
	 * 	if the process was successful will return true and an empty String, if the
	 *  process wasn't successful will return false and the error 
	 */
	public static Pair<Boolean, String> saveGame(Game game, String directory) {
		Pair<Boolean, String> result = new Pair<Boolean, String>(true, "");
		try {
			//TODO
		} catch (Exception e) {
			result = new Pair<Boolean, String>(false, e.getMessage());
		}

		return result;
	}
}
