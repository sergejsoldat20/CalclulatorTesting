package exceptions;

/**
 * @author Sergej Soldat
 * @version 1
 * This Exception should be thrown when Calculator is using operation that is not +, -, *, /. 
 */
public class NotSupportedOperationException extends Exception {

	/**
	 * Exception without a specific message.
	 */
	public NotSupportedOperationException() {
		super();
	}

	/**
	 * Exception with specific message
	 * @param message
	 */
	public NotSupportedOperationException(String message) {
		super(message);
	}
}
