import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

import exceptions.UnableToLoadException;
import exceptions.UnableToSaveException;
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

public class SaveMagager {

	/**
	 * The directory and name of the last file this class saved a game on
	 */
	static String lastFileUsed = "";

	/**
	 * 
	 * @param game
	 * @param directory
	 * @param directory
	 * @throws UnableToSaveException
	 * @throws IOException
	 */
	public static void autoSaveGame(Game game, String directory) throws UnableToSaveException, IOException {
		String name = generateSaveFileName(game);
		createOrOverrideFile(directory, name, "save");
		String completePath = directory + "/" + "name" + ".save";
		lastFileUsed = completePath;
		saveGame(game, completePath);
	}

	/**
	 * This function will throw an UnableToSaveException if any exception is raised
	 * during the process
	 * 
	 * @param game: The game to save
	 * @param file: The directory where it will be saved, the file will be created
	 *              and will override any existent file
	 * @throws UnableToSaveException
	 */
	public static void saveGame(Game game, String file) throws UnableToSaveException {
		try {
			FileOutputStream fileOutput = new FileOutputStream(new File(file));
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(game);
			lastFileUsed = file;
			fileOutput.close();
			objectOutput.close();
		} catch (Exception e) {
			throw new UnableToSaveException(e);
		}

	}

	/**
	 * 
	 * @param file: The file where the game will be loaded
	 * @throws UnableToSaveException
	 * @return The game loaded
	 * @throws UnableToLoadException
	 */
	public static Game loadGame(String file) throws UnableToLoadException {
		try {
			FileInputStream fileInput = new FileInputStream(new File(file));
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			Game result = (Game) objectInput.readObject();
			fileInput.close();
			objectInput.close();
			return result;
		} catch (Exception e) {
			throw new UnableToLoadException(e);
		}
	}

	/**
	 * Creates or override if already exists the given file.
	 * 
	 * @param directory: Where will be created the file
	 * @param name:      The name of the file
	 * @param extension: The extensions of the file
	 * @throws IOException
	 */
	public static void createOrOverrideFile(String directory, String name, String extension) throws IOException {
		Writer fileWriter = new FileWriter(directory + "/" + "name" + "." + extension, false);
		fileWriter.close();
	}

	/**
	 * Call generateSaveFileName with the game title
	 * 
	 * @param game: The Game which title will be used
	 * @return
	 */
	public static String generateSaveFileName(Game game) {
		return generateSaveFileName(game.getGameTitle());
	}

	/**
	 * Generates a name using the current timestamp and
	 * 
	 * @param name: The game name
	 * @return The generated file name
	 */
	public static String generateSaveFileName(String name) {
		return new Timestamp(new Date().getTime()).toString() + "_" + name;
	}
}
