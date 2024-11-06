package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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
    }

    // transform input, some elements to fizz
    @Test
    void functionThatFizzes() {
        List<String> input = List.of("1", "2", "3");
        Function<String, String> fizzFunction = it -> {
            if (Integer.parseInt(it) % 3 == 0) {
                return "fizz";
            }
            return it;
        };

        Stream<String> mapped = input.stream()
                .map(fizzFunction);
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
        Function<String, String> buzzFunction = it -> {
            if (Integer.parseInt(it) % 5 == 0) {
                return "Buzz";
            }
            return it;
        };

        Stream<String> mapped = input.stream()
                .map(buzzFunction);
        String Buzzed = mapped.collect(Collectors.joining(","));
        assertEquals("1,Buzz", Buzzed);
    }

    @Test
    void functionThatFizzBuzzes() {
        List<String> input = List.of("15", "30");
        Function<String, String> buzzFunction = it -> {
            if ((Integer.parseInt(it) % 3 == 0) && (Integer.parseInt(it) % 5 == 0)) {
                return "FizzBuzz";
            }
            return it;
        };

        Stream<String> mapped = input.stream()
                .map(buzzFunction);
        String FizzBuzzed = mapped.collect(Collectors.joining(","));
        assertEquals("FizzBuzz,FizzBuzz", FizzBuzzed);
    }

    @Test
    void functionThatPopulatesList() {
        int input = 3;
        Function<Integer, List<String>> PopulateFunction = it -> {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < it; i++) {
                list.add(i + 1 + "");
            }
            return list;


        };

        assertEquals(List.of("1", "2", "3"), PopulateFunction.apply(3));
    }
}


