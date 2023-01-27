package exceptions;

/**
 * @author Sergej Soldat
 * This Exception will be thrown is a number is not in allowed area
 */
public class NumberNotInAreaException extends Exception {

	/**
	 * Exception without a specific message.
	 */
	public NumberNotInAreaException()
	{
		super();
	}
	
	/**
	 * Exception with a specific message.
	 * @param message If the NumberNotInAreaException exception is thrown, this message will be displayed.
	 */
	public NumberNotInAreaException(String message)
	{
		super(message);
	}
}
