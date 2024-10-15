package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest {


    /**
     * pass a $number, it returns an array containing the numbers from 1 to $number,
     * but: for ech number divisible by 3, return "fizz" instead
     */
    @Test
    public void testFizz() {
        assertEquals("1,2,fizz,4,5,fizz,7", String.join(",", App.fizz(7)));
    }


    /**
     * pass a $number, it returns an array containing the numbers from 1 to $number,
     * but: for each number divisible by 3, return "fizz" instead
     * and: for each number divisible by 5, return "buzz" instead
     * and if both is true, "fizzbuzz"
     */
    //@Test
    //public void shouldAnswerWithTrue() {
    //            assertEquals("1,2,Fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", App.fizz(15));
    //}
}
