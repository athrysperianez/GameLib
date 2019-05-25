import java.io.Serializable;

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

public class Section implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2635539824403895251L;
	/**
	 * @author Elias Periañez This is the parameter that show which unit is on it,
	 *         if it´s null means that the section is empty
	 */
	private Unit unitOnIt = null;

	public Unit getUnitOnIt() {
		return unitOnIt;
	}
	
	//TODO Javadoc
	public boolean setUnitOnIt(Unit newUnit) {
		boolean result = (unitOnIt == null) ? true : false;
		if (result) {
			this.unitOnIt = newUnit;
		}
		return result;
	}

	/**
	 * TODO Javadoc
	 * The return is the previous unit, in case you want to move it or do something instead of just destroying it
	 */
	public Unit overrideUnitOnIt(Unit newUnit) {
		Unit storedUnit = this.unitOnIt;
		this.unitOnIt = newUnit;
		return storedUnit;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" Unit on it : ").append(this.unitOnIt).toString();
	}
	
}
