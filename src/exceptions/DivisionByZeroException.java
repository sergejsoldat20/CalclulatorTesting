package exceptions;

/**
 * @author Sergej Soldat
 * @version 1
 * This Exception should be thrown when Calculator is using 0 on operation division.
 */
public class DivisionByZeroException extends Exception {
	
	/**
	 * Exception without a specific message.
	 */
	public DivisionByZeroException() {
		super();
	}
	
	/**
	 * Exception with specific message
	 * @param message If the NumberNotInAreaException exception is thrown, this message will be displayed.
	 */
	public DivisionByZeroException(String message) {
		super(message);
	}

}
