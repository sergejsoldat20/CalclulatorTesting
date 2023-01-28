package exceptions;

/**
 * @author Sergej Soldat
 * @version 1
 * This Exception should be thrown when operations in methods are not allowed. 
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
	 * @param message If the NumberNotInAreaException exception is thrown, this message will be displayed.
	 */
	public NotSupportedOperationException(String message) {
		super(message);
	}
}
