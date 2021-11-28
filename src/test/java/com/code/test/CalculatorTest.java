package com.code.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = null;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturnSumOfTwoNumber2And5As7() {
        int sum = calculator.add(2, 5);
        Assertions.assertEquals(7, sum);
    }

    @Test
    void shouldReturn2When10DivideBy5() {
        double value = calculator.divide(10, 5);
        Assertions.assertEquals(2, value);
    }

    @Test
    void shouldReturnArithmeticExceptionWhenDividedBy0() {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0));
        Assertions.assertEquals("0으로 나눌 수 없습니다.", arithmeticException.getMessage());
    }

}