/**
 * 
 */
package exceptions;

/**
 * @author Elias Periañez 
 * This exception will be launched when some parts of
 * your game don´t have any code on them but you need to implement them
 * in order for the game to work
 */
public class NotImplementedException extends Exception {

	private static final long serialVersionUID = -124517104129389217L;

	public NotImplementedException(String errorMessage) {
		super(errorMessage);
	}
	
	public NotImplementedException() {
		super("Required code was not implemented");
	}

}
