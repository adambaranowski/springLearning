package pl.adambaranowski.mocktesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    //preparation
    @BeforeEach
    void prepare(){
        this.calculator = new Calculator();
    }

    @Test
    void shouldAddTwoNumbers() {
        //given
        //in preparation

        //when
        int result = calculator.add(3, 2);
        //then
        assertEquals(5, result);
    }

    @Test
    void shouldNoAddTwoNumbers() {
        //given
        //in preparation

        //when
        //then
        assertNotEquals(5, calculator.add(2,2));
    }

    @Test
    void shouldDivideTwoNumbers() {
        assertEquals(10, calculator.divide(100,10));
    }

    @Test
    void shouldThrowArithmeticExceptionWhenDivideByZero(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(10,0));
    }
}