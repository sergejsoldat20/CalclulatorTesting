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
	void testCalculateAdvanced(Double result, Double currentValue, char action) throws NumberNotInAreaException, NotSupportedOperationException, DivisionByZeroException
	{
		calculatorAdvanced.setCurrentValue(currentValue);
		calculatorAdvanced.calculateAdvanced(action);
		assertThat(result, is(calculatorAdvanced.getCurrentValue()));
	}
	
	private static Stream<Arguments> paramsForCalculateAdvanced()
	{
	    return Stream.of(
	      Arguments.of(1.0, 0.0, '0'),
	      Arguments.of(1.0, 0.10, '0'),
	      Arguments.of(1.0, -0.10, '0'),
	      Arguments.of(1.0, 5.0, '0'),
	      Arguments.of(1.0, 5.55, '0'),
	      Arguments.of(1.0, -5.0, '0'),
	      Arguments.of(1.0, -5.55, '0'),
	      
	      Arguments.of(0.0, 0.0, '1'),
	      Arguments.of(0.0, 0.55, '1'),
	      Arguments.of(-0.0, -0.55, '1'),
	      Arguments.of(5.0, 5.0, '1'),
	      Arguments.of(5.0, 5.55, '1'),
	      Arguments.of(-5.0, -5.0, '1'),
	      Arguments.of(-5.0, -5.55, '1'),
	      
	      Arguments.of(0.0, 0.0, '2'),
	      Arguments.of(0.0, 0.55, '2'),
	      Arguments.of(0.0, -0.55, '2'),
	      Arguments.of(25.0, 5.0, '2'),
	      Arguments.of(25.0, 5.55, '2'),
	      Arguments.of(25.0, -5.0, '2'),
	      Arguments.of(25.0, -5.55, '2'),
	      
	      Arguments.of(0.0, 0.0, '3'),
	      Arguments.of(0.0, 0.55, '3'),
	      Arguments.of(-0.0, -0.55, '3'),
	      Arguments.of(125.0, 5.0, '3'),
	      Arguments.of(125.0, 5.55, '3'),
	      Arguments.of(-125.0, -5.0, '3'),
	      Arguments.of(-125.0, -5.55, '3'),
	      
	      Arguments.of(0.0, 0.0, '4'),
	      Arguments.of(0.0, 0.55, '4'),
	      Arguments.of(0.0, -0.55, '4'),
	      Arguments.of(625.0, 5.0, '4'),
	      Arguments.of(625.0, 5.55, '4'),
	      Arguments.of(625.0, -5.0, '4'),
	      Arguments.of(625.0, -5.55, '4'),
	      
	      Arguments.of(0.0, 0.0, '5'),
	      Arguments.of(0.0, 0.55, '5'),
	      Arguments.of(-0.0, -0.55, '5'),
	      Arguments.of(32.0, 2.0, '5'),
	      Arguments.of(32.0, 2.55, '5'),
	      Arguments.of(-32.0, -2.0, '5'),
	      Arguments.of(-32.0, -2.55, '5'),
	      
	      Arguments.of(0.0, 0.0, '6'),
	      Arguments.of(0.0, 0.55, '6'),
	      Arguments.of(0.0, -0.55, '6'),
	      Arguments.of(64.0, 2.0, '6'),
	      Arguments.of(64.0, 2.55, '6'),
	      Arguments.of(64.0, -2.0, '6'),
	      Arguments.of(64.0, -2.55, '6'),
	      
	      Arguments.of(0.0, 0.0, '7'),
	      Arguments.of(0.0, 0.55, '7'),
	      Arguments.of(-0.0, -0.55, '7'),
	      Arguments.of(128.0, 2.0, '7'),
	      Arguments.of(128.0, 2.55, '7'),
	      Arguments.of(-128.0, -2.0, '7'),
	      Arguments.of(-128.0, -2.55, '7'),
	      
	      Arguments.of(0.0, 0.0, '8'),
	      Arguments.of(0.0, 0.55, '8'),
	      Arguments.of(0.0, -0.55, '8'),
	      Arguments.of(256.0, 2.0, '8'),
	      Arguments.of(256.0, 2.55, '8'),
	      Arguments.of(256.0, -2.0, '8'),
	      Arguments.of(256.0, -2.55, '8'),
	      
	      Arguments.of(0.0, 0.0, '9'),
	      Arguments.of(0.0, 0.1223, '9'),
	      Arguments.of(-0.0, -0.40, '9'),
	      Arguments.of(512.0, 2.0, '9'),
	      Arguments.of(512.0, 2.124123, '9'),
	      Arguments.of(-512.0, -2.0, '9'),
	      Arguments.of(-512.0, -2.55, '9'),
	      
	      Arguments.of(1.0, 0.0, '!'),
	      Arguments.of(1.0, 0.55, '!'),
	      Arguments.of(120.0, 5.0, '!'),
	      Arguments.of(120.0, 5.55, '!'),
	      Arguments.of(362880.0, 9.55, '!'),
	      Arguments.of(3628800.0, 10.0, '!')
	    );
	}
	
	

}
