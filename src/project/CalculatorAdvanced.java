package project;
import exceptions.*;
/**
 * @author serge
 *
 */
public class CalculatorAdvanced extends Calculator{

	/**
     * Method for advanced calculations.
     * 
     * @param action - the action to perform, can be a digit from 0 to 9 or the character '!'
     * @throws DivisionByZeroException if the value of currentValue is 0 and action is '/'
     * @throws NotSupportedOperationException if the value of action is not a digit from 0 to 9 or '!'
     * @throws NumberNotInAreaException if currentValue is not in the range of [0, 10] when action is '!' 
     */
	public void calculateAdvanced(char action) throws DivisionByZeroException,
	NotSupportedOperationException, NumberNotInAreaException {
		if(Character.isDigit(action)) {
			int digit = Character.getNumericValue(action);
			super.setCurrentValue(Double.valueOf(pow(roundNumber(), digit)));
		} else if (action == '!') {
            if (super.getCurrentValue() < 0 || super.getCurrentValue() > 10) {
                throw new NumberNotInAreaException("currentValue must be in the range of [0, 10] when calculating factorial");
            }
            super.setCurrentValue(Double.valueOf(factorial(super.getCurrentValue().intValue())));
		} else {
			throw new NotSupportedOperationException("Action is not supported");
		}
	}
	
	public int factorial(int n) {
	    int result = 1;
	    for (int i = 1; i <= n; i++) {
	        result *= i;
	    }
	    return result;
	}
	
	public static Double pow(Double base, int exponent) {
		System.out.println(base);
	    Double result = 1.0;
	    for (int i = 0; i < Math.abs(exponent); i++) {
	        result *= base;
	    }
	    if(exponent < 0)
	        return 1/result;
	    else
	        return result;
	}
	
	/**
	 * This function checks if number is perfect 
	 * @param num
	 * @return boolean
 	 */
	public boolean isPerfectNumber(int num) {
	    int sum = 0;
	    for (int i = 1; i < num; i++) {
	        if (num % i == 0) {
	            sum += i;
	        }
	    }
	    return (sum == num);
	}

	/**
	 * @param num
	 * @return
	 */
	public boolean isArmstrongNumber(int num) {
	    int originalNum = num;
	    int result = 0;
	    int n = 0;
	    while (originalNum != 0) {
	        originalNum /= 10;
	        ++n;
	    }
	    originalNum = num;
	    while (originalNum != 0) {
	        int remainder = originalNum % 10;
	        result += Math.pow(remainder, n);
	        originalNum /= 10;
	    }
	    return (result == num);
	}
	
	
	/**
	 * This method checks if currentValue is Armstrong number or perfect number and returns 
	 * true, otherwise it returns false. Method accepts @param value and it can be 'A' to 
	 * check Armstrong number or 'P' to check if it is perfect number.
	 * @param value
	 * @return Boolean
	 * @throws NumberNotInAreaException is thrown if currentValue integer is less than 1
	 * @throws NotSupportedOperationException if @param value is not 'A' or 'P'
	 */
	public Boolean hasCharacteristic(char value) throws NumberNotInAreaException, NotSupportedOperationException {
        int currentValueInt = super.getCurrentValue().intValue();
        if (currentValueInt < 1) {
            throw new NumberNotInAreaException("Current value must be greater than or equal to 1.");
        }
        if (value == 'A') {
            return isArmstrongNumber(currentValueInt);
        } else if (value == 'P') {
            return isPerfectNumber(currentValueInt);
        } else {
            throw new NotSupportedOperationException("Invalid value: " + value + ". Only 'A' and 'P' are supported.");
        }
    }
	
	/*public Double roundNumber()
	{
		String s1 = String.valueOf(getCurrentValue());
		int index = s1.indexOf('.');
		String s2 = s1.substring(0, index);
		Double cjelobrojniDio = Double.parseDouble(s2);
		return cjelobrojniDio;
	}*/
	
	public Double roundNumber() {
		return (getCurrentValue() >= 0) ? 
				Math.floor(getCurrentValue()) : -1 * Math.floor(Math.abs(getCurrentValue()));
	}
	
	public static void main(String args[]) throws Exception {
		CalculatorAdvanced ca = new CalculatorAdvanced();
		ca.setCurrentValue(0.55);
		//ca.calculateAdvanced('1');
		//System.out.println(ca.getCurrentValue());
		System.out.print(ca.roundNumber());
		ca.setCurrentValue(-0.55);
		System.out.print(ca.roundNumber());
	}
}
