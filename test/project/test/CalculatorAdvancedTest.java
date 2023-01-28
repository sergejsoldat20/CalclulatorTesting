package project.test;
import exceptions.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import project.CalculatorAdvanced;

class CalculatorAdvancedTest {
	
	public CalculatorAdvanced calculatorAdvanced = new CalculatorAdvanced();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testCalculatorAdvanced() {
		assertNotNull(calculatorAdvanced);
	}

	@Test
	void testCalculateAdvanced() {
		Exception exception1 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.calculateAdvanced('A'));
        assertThat(exception1, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.calculateAdvanced('a'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception3 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.calculateAdvanced('+'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
        calculatorAdvanced.setCurrentValue(-0.5);
        Exception exception4 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.calculateAdvanced('!'));
        assertThat(exception4, is(instanceOf(NumberNotInAreaException.class)));
        
        calculatorAdvanced.setCurrentValue(10.5);
        Exception exception5 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.calculateAdvanced('!'));
        assertThat(exception5, is(instanceOf(NumberNotInAreaException.class)));
	}
	
	
	@ParameterizedTest
	@MethodSource("paramsForCalculateAdvanced")
	void testCalculateAdvanced(Double result, Double currentValue, char action) throws NumberNotInAreaException,
	NotSupportedOperationException, DivisionByZeroException {
		calculatorAdvanced.setCurrentValue(currentValue);
		calculatorAdvanced.calculateAdvanced(action);
		assertThat(result, is(calculatorAdvanced.getCurrentValue()));
	}
	
	private static Stream<Arguments> paramsForCalculateAdvanced() {
	    return Stream.of(
	      Arguments.of(1.0, 0.0, '0'),
	      Arguments.of(1.0, 0.10, '0'),
	      Arguments.of(1.0, -0.10, '0'),
	      Arguments.of(1.0, 6.0, '0'),
	      Arguments.of(1.0, 6.66, '0'),
	      Arguments.of(1.0, -6.0, '0'),
	      Arguments.of(1.0, -6.66, '0'),
	      
	      Arguments.of(0.0, 0.0, '1'),
	      Arguments.of(0.0, 0.10, '1'),
	      Arguments.of(-0.0, -0.10, '1'),
	      Arguments.of(6.0, 6.0, '1'),
	      Arguments.of(6.0, 6.66, '1'),
	      Arguments.of(-6.0, -6.0, '1'),
	      Arguments.of(-6.0, -6.66, '1'),

	      Arguments.of(0.0, 0.0, '2'),
	      Arguments.of(0.0, 0.10, '2'),
	      Arguments.of(0.0, -0.10, '2'),
	      Arguments.of(36.0, 6.0, '2'),
	      Arguments.of(36.0, 6.66, '2'),
	      Arguments.of(36.0, -6.0, '2'),
	      Arguments.of(36.0, -6.66, '2'),
	      
	      Arguments.of(0.0, 0.0, '3'),
	      Arguments.of(0.0, 0.10, '3'),
	      Arguments.of(-0.0, -0.10, '3'),
	      Arguments.of(216.0, 6.0, '3'),
	      Arguments.of(216.0, 6.66, '3'),
	      Arguments.of(-216.0, -6.0, '3'),
	      Arguments.of(-216.0, -6.66, '3'),
	      
	      Arguments.of(0.0, 0.0, '4'),
	      Arguments.of(0.0, 0.10, '4'),
	      Arguments.of(0.0, -0.10, '4'),
	      Arguments.of(1296.0, 6.0, '4'),
	      Arguments.of(1296.0, 6.66, '4'),
	      Arguments.of(1296.0, -6.0, '4'),
	      Arguments.of(1296.0, -6.66, '4'),
	      
	      Arguments.of(0.0, 0.0, '5'),
	      Arguments.of(0.0, 0.10, '5'),
	      Arguments.of(-0.0, -0.10, '5'),
	      Arguments.of(7776.0, 6.0, '5'),
	      Arguments.of(7776.0, 6.66, '5'),
	      Arguments.of(-7776.0, -6.0, '5'),
	      Arguments.of(-7776.0, -6.66, '5'),
	      
	      Arguments.of(0.0, 0.0, '6'),
	      Arguments.of(0.0, 0.10, '6'),
	      Arguments.of(0.0, -0.10, '6'),
	      Arguments.of(46656.0, 6.0, '6'),
	      Arguments.of(46656.0, 6.66, '6'),
	      Arguments.of(46656.0, -6.0, '6'),
	      Arguments.of(46656.0, -6.66, '6'),
	      
	      Arguments.of(0.0, 0.0, '7'),
	      Arguments.of(0.0, 0.10, '7'),
	      Arguments.of(-0.0, -0.10, '7'),
	      Arguments.of(279936.0, 6.0, '7'),
	      Arguments.of(279936.0, 6.66, '7'),
	      Arguments.of(-279936.0, -6.0, '7'),
	      Arguments.of(-279936.0, -6.66, '7'),
	      
	      Arguments.of(0.0, 0.0, '8'),
	      Arguments.of(0.0, 0.10, '8'),
	      Arguments.of(0.0, -0.10, '8'),
	      Arguments.of(1679616.0, 6.0, '8'),
	      Arguments.of(1679616.0, 6.66, '8'),
	      Arguments.of(1679616.0, -6.0, '8'),
	      Arguments.of(1679616.0, -6.66, '8'),
	      
	      Arguments.of(0.0, 0.0, '9'),
	      Arguments.of(0.0, 0.10, '9'),
	      Arguments.of(-0.0, -0.10, '9'),
	      Arguments.of(10077696.0, 6.0, '9'),
	      Arguments.of(10077696.0, 6.66, '9'),
	      Arguments.of(-10077696.0, -6.0, '9'),
	      Arguments.of(-10077696.0, -6.66, '9'),
	      
	      Arguments.of(1.0, 0.0, '!'),
	      Arguments.of(1.0, 0.55, '!'),
	      Arguments.of(120.0, 5.0, '!'),
	      Arguments.of(120.0, 5.55, '!'),
	      Arguments.of(362880.0, 9.55, '!'),
	      Arguments.of(3628800.0, 10.0, '!')
	    );
	}
	
	@Test
	void hasCharacteristic() throws NumberNotInAreaException,
	NotSupportedOperationException {
		
		calculatorAdvanced.setCurrentValue(2.0);
		
        Exception exception1 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.hasCharacteristic('.'));
        assertThat(exception1, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.hasCharacteristic('2'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception3 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.hasCharacteristic('a'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception4 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.hasCharacteristic('p'));
        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception5 = assertThrows(NotSupportedOperationException.class, () -> calculatorAdvanced.hasCharacteristic('V'));
        assertThat(exception5, is(instanceOf(NotSupportedOperationException.class)));
        
        calculatorAdvanced.setCurrentValue(0.2);
        Exception exception6 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.hasCharacteristic('A'));
        assertThat(exception6, is(instanceOf(NumberNotInAreaException.class)));
        
        Exception exception7 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.hasCharacteristic('P'));
        assertThat(exception7, is(instanceOf(NumberNotInAreaException.class)));
        
        calculatorAdvanced.setCurrentValue(-2.4);
        Exception exception8 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.hasCharacteristic('A'));
        assertThat(exception8, is(instanceOf(NumberNotInAreaException.class)));
        
        Exception exception9 = assertThrows(NumberNotInAreaException.class, () -> calculatorAdvanced.hasCharacteristic('P'));
        assertThat(exception9, is(instanceOf(NumberNotInAreaException.class)));
	}
	
	@Test
	void testPow() {
		assertThat(64.0, is(calculatorAdvanced.pow(4.0, 3)));
		assertThat(1.0, is(calculatorAdvanced.pow(4.0, 0)));
		assertThat(0.0, is(calculatorAdvanced.pow(0.0, 1)));
	}
	
	@Test
	void testFactorial() {
		assertThat(120, is(calculatorAdvanced.factorial(5)));
		assertThat(6, is(calculatorAdvanced.factorial(3)));
	}
	
	@Test
	void testRoundNumber() {
		calculatorAdvanced.setCurrentValue(-6.66);
		assertThat(-6.0, is(calculatorAdvanced.roundNumber()));
		calculatorAdvanced.setCurrentValue(5.23);
		assertThat(5.0, is(calculatorAdvanced.roundNumber()));
	}
	
	@Test
	void testIsArmstrong() {
		assertThat(true, is(calculatorAdvanced.isArmstrongNumber(153)));
		assertThat(false, is(calculatorAdvanced.isArmstrongNumber(1235)));
	}
	
	@Test
	void testIsPerfect() {
		assertThat(true, is(calculatorAdvanced.isPerfectNumber(496)));
		assertThat(false, is(calculatorAdvanced.isPerfectNumber(555)));
	}
	
	@ParameterizedTest
	@MethodSource("paramsForHasCharacteristic")
	void testHasCharacteristic(Boolean result, Double currentValue, char value) throws NumberNotInAreaException, NotSupportedOperationException {
		calculatorAdvanced.setCurrentValue(currentValue);
		assertThat(result, is(calculatorAdvanced.hasCharacteristic(value)));
	}
	
	private static Stream<Arguments> paramsForHasCharacteristic() {
		 return Stream.of(
			      Arguments.of(true, 1.0, 'A'),
			      Arguments.of(true, 1.66, 'A'),
			      Arguments.of(true, 2.0, 'A'),
			      Arguments.of(true, 2.66, 'A'),
			      Arguments.of(true, 153.0, 'A'),
			      Arguments.of(true, 153.66, 'A'),
			      Arguments.of(true, 1634.0, 'A'),
			      Arguments.of(true, 1634.66, 'A'),
			      Arguments.of(false, 10.0, 'A'),
			      Arguments.of(false, 10.55, 'A'),
			      Arguments.of(false, 496.0, 'A'),
			      Arguments.of(false, 496.66, 'A'),
			      Arguments.of(false, 42341.0, 'A'),
			      Arguments.of(false, 42341.66, 'A'),
			      Arguments.of(true, 6.0, 'P'),
			      Arguments.of(true, 6.55, 'P'),
			      Arguments.of(true, 28.0, 'P'),
			      Arguments.of(true, 28.55, 'P'),
			      Arguments.of(true, 496.0, 'P'),
			      Arguments.of(true, 496.55, 'P'),
			      Arguments.of(true, 8128.0, 'P'),
			      Arguments.of(true, 8128.55, 'P'),
			      Arguments.of(false, 1.0, 'P'),
			      Arguments.of(false, 1.55, 'P'),
			      Arguments.of(false, 11.0, 'P'),
			      Arguments.of(false, 11.55, 'P'),
			      Arguments.of(false, 144.0, 'P'),
			      Arguments.of(false, 144.11, 'P'),
			      Arguments.of(false, 1231234.0, 'P'),
			      Arguments.of(false, 1231234.43, 'P')
			    );
	}
	
	

}
