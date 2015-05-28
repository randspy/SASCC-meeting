package com.company;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {


    private StringCalculator calc;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp(){
        calc = new StringCalculator();
    }

    @Test
    public void when_empty_input_returns_zero() {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void when_one_number_returns_the_number() {
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void when_two_numbers_returns_sum() {
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void when_many_numbers_then_return_theirs_sum() {
        assertEquals(6, calc.add("1,2,3"));
    }

    @Test
    public void should_support_numbers_with_many_digits() {
        assertEquals(10, calc.add("10"));
    }

    @Test
    public void should_accept_new_line_separator() {
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void should_accept_custom_separator() {
        assertEquals(3, calc.add("//;\n1;2"));
    }

    @Test
    public void should_throw_for_negative_number() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -1");
        calc.add("-1,2");
    }

    @Test
    public void should_throw_for_many_negative_numbers() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Negatives not allowed: -4,-5");
        calc.add("2,-4,3,-5");
    }

}