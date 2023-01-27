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
	 * @param message
	 */
	public DivisionByZeroException(String message) {
		super(message);
	}

}
