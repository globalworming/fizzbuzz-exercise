package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {

    public static final Function<Integer, List<String>> POPULATE_FUNCTION = it -> {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < it; i++) {
            list.add(i + 1 + "");
        }
        return list;

    };

    public static final Function<String, String> FIZZ_FUNCTION = it -> {
        try {
            if (Integer.parseInt(it) % 3 == 0) {
                return "fizz";
            }

        } catch (NumberFormatException e) {
            return it;


        }


        return it;
    };
    public static final Function<String, String> BUZZ_FUNCTION = it -> {
        try {
            if (Integer.parseInt(it) % 5 == 0) {
                return "buzz";
            }

        } catch (NumberFormatException e) {

        }

        return it;
    };
    public static final Function<String, String> FIZZBUZZ = it -> {
        try {
            if ((Integer.parseInt(it) % 3 == 0) && (Integer.parseInt(it) % 5 == 0)) {
                return "fizzbuzz";
            }
        } catch (NumberFormatException e) {
        }
        return it;
    };


    public static List<String> fizz(int number) {
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean isDivisibleByThreeWithoutRest = i % 3 == 0;
            boolean isDivisibleByFiveWithoutRest = i % 5 == 0;
            boolean isDivisibleByBoth = i % 3 == 0 & i % 5 == 0;

            if (isDivisibleByBoth) {
                numbers.add("fizzbuzz");
            } else if (isDivisibleByThreeWithoutRest) {
                numbers.add("fizz");
            } else if (isDivisibleByFiveWithoutRest) {
                numbers.add("buzz");
            } else {
                numbers.add(String.valueOf(i));
            }
        }
        return numbers;
    }

    public static List<String> initList(int i) {
        return null;
    }

    public static List<String> fizz2(int number) {

        return POPULATE_FUNCTION.apply(number)
                .stream()
                .map(FIZZBUZZ)
                .map(FIZZ_FUNCTION)
                .map(BUZZ_FUNCTION)

                .collect(Collectors.toList());


    }
}

