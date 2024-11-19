package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        assertEquals("1,2,fizz,4,buzz,fizz,7", String.join(",", App.fizz(7)));
    }


    /**
     * pass a $number, it returns an array containing the numbers from 1 to $number,
     * but: for each number divisible by 3, return "fizz" instead
     * and: for each number divisible by 5, return "buzz" instead
     * and if both is true, "fizzbuzz"
     */
    @Test
    public void alsoSupportsFizzBuzz() {
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", String.join(",", App.fizz(15)));
        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", String.join(",", App.fizz2(15)));

    }

    // transform input, some elements to fizz
    @Test
    void functionThatFizzes() {
        List<String> input = List.of("1", "2", "3");

        Stream<String> mapped = input.stream()
                .map(App.FIZZ_FUNCTION);
        String fizzed = mapped.collect(Collectors.joining(","));
        assertEquals("1,2,fizz", fizzed);
    }

    @Test
    @Disabled("TODO")
    void functionThatReturnsStringsOfIncrementingNumbers() {
        //assertEquals("1,2,3,4,5", String.join(",", App.initList(5)));
    }

    @Test
    void functionThatBuzzes() {
        List<String> input = List.of("1", "5");

        Stream<String> mapped = input.stream()
                .map(App.BUZZ_FUNCTION);
        String Buzzed = mapped.collect(Collectors.joining(","));
        assertEquals("1,buzz", Buzzed);
    }

    @Test
    void functionThatFizzBuzzes() {
        List<String> input = List.of("15", "30");

        Stream<String> mapped = input.stream()
                .map(App.FIZZBUZZ);
        String FizzBuzzed = mapped.collect(Collectors.joining(","));
        assertEquals("fizzbuzz,fizzbuzz", FizzBuzzed);
    }

    @Test
    void functionThatPopulatesList() {
        int input = 3;

        assertEquals(List.of("1", "2", "3"), App.POPULATE_FUNCTION.apply(3));
    }
}


