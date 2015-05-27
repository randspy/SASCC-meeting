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
    public void emptyInput() {
        assertEquals(0, calc.add(""));
    }


    @Test
    public void oneNumber() {
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void When_1_and_2_Then_return_3() {
        assertEquals(3, calc.add("1,2"));
    }
    @Test
    public void should_support_numbers_with_many_digits() {
        assertEquals(10, calc.add("10"));
    }

    @Test
    public void When_Many_Numbers_Then_Return_Theirs_Sum() {
        assertEquals(6, calc.add("1,2,3"));
    }

    @Test
    public void When_New_Line_Separator() {
        assertEquals(6, calc.add("1\n2,3"));
    }

    @Test
    public void CustomDelimiter() {
        assertEquals(3, calc.add("//;\n1;2"));
    }

//    @Test
//    public void negative_number_should_throw() {
//
//        exception.expect(IllegalArgumentException.class);
//
//        calc.add("-1,2");
//    }


}