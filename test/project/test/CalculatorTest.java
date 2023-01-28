package project.test;

import static org.junit.jupiter.api.Assertions.*;
import exceptions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import project.Calculator;

class CalculatorTest {
	
	Calculator calculator = new Calculator();

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
	void testCalculator() {
		assertNotNull(calculator);
	}

	@Test
	void testGetCurrentValue() {
		calculator.setCurrentValue(6.2);
		assertThat(6.2, is(calculator.getCurrentValue()));
	}

	@Test
	void testSetCurrentValue() {
		calculator.setCurrentValue(6.2);
		assertThat(6.2, is(calculator.getCurrentValue()));
	}

	@Test
	void testCalculate() throws DivisionByZeroException,
		NotSupportedOperationException {
		Exception exception1 = assertThrows(DivisionByZeroException.class, () -> calculator.calculate(0.0, '/'));
        assertThat(exception1, is(instanceOf(DivisionByZeroException.class)));
        
        Exception exception2 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(0.0, 's'));
        assertThat(exception2, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception3 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(0.0, 'S'));
        assertThat(exception3, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception4 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(0.0, '1'));
        assertThat(exception4, is(instanceOf(NotSupportedOperationException.class)));
        
        Exception exception5 = assertThrows(NotSupportedOperationException.class, () -> calculator.calculate(0.0, ']'));
        assertThat(exception5, is(instanceOf(NotSupportedOperationException.class)));
	}
	
	@ParameterizedTest
	@MethodSource("paramsForCalculate")
	void testCalculate(Double result, Double currentValue, 
			Double value, char operator) throws DivisionByZeroException,
		NotSupportedOperationException {
		calculator.setCurrentValue(currentValue);
		calculator.calculate(value, operator);
		assertThat(result, is(calculator.getCurrentValue()));
	}
	
	private static Stream<Arguments> paramsForCalculate() {
        return Stream.of(
                Arguments.of(5.0, 2.0, 3.0, '+'),
                Arguments.of(-1.0, 2.0, 3.0, '-'),
                Arguments.of(6.0, 2.0, 3.0, '*'),
                Arguments.of(1.5, 3.0, 2.0, '/'),
                Arguments.of(2.0, 2.0, 0.0, '+'),
                Arguments.of(2.0, 2.0, 0.0, '-'),
                Arguments.of(-5.0, -2.0, -3.0, '+'),
                Arguments.of(1.0, -2.0, -3.0, '-'),
                Arguments.of(6.0, -2.0, -3.0, '*'),
                Arguments.of(1.5, -3.0, -2.0, '/'),
                Arguments.of(-2.0, -2.0, 0.0, '+'),
                Arguments.of(-2.0, -2.0, 0.0, '-'),
                Arguments.of(-3.0, 0.0, -3.0, '+'),
                Arguments.of(3.0, 0.0, -3.0, '-'),
                Arguments.of(-0.0, 0.0, -3.0, '*')
        );
    }

}
