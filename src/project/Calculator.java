package project;
import java.util.function.BinaryOperator;
import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

/**
 * Calculator class that performs basic mathematical operations.
 * @author Sergej Soldat
 */
public class Calculator {

	
	private Double currentValue = 0.0;
	
	/**
     * Constructor creates new object.
     */
	public Calculator() {
		super();
	}

	/**
     * Returns the current value.
     * @return current value
     */
	public Double getCurrentValue() {
		return currentValue;
	}

	/**
     * Sets the current value.
     * @param currentValue the value to set
     */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	/**
    * Performs a mathematical operation on the current value and a given value.
    * @param value the value to perform the operation on
    * @param operator the operator to perform the operation (+, -, *, /)
    * @throws DivisionByZeroException if operator is '/' and value is 0
    * @throws NotSupportedOperationException if operator is not one of (+, -, *, /)
    */
	public void calculate(Double value, char operator) throws DivisionByZeroException,NotSupportedOperationException {
		 BinaryOperator<Double> operation = null;
	        switch (operator) {
	            case '+':
	                operation = (x, y) -> x + y;
	                break;
	            case '-':
	                operation = (x, y) -> x - y;
	                break;
	            case '*':
	                operation = (x, y) -> x * y;
	                break;
	            case '/':
	                if (value == 0) {
	                    throw new DivisionByZeroException("Division by zero is not allowed.");
	                }
	                operation = (x, y) -> x / y;
	                break;
	            default :
	            	throw new NotSupportedOperationException("Operation is not allowed.");
	            
	        }
	        this.currentValue = operation.apply(this.currentValue, value);
	}

}
