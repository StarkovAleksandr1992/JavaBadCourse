package ru.starkov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EighthTask {

    public static int sumOfLettersInWordsLongerThanFour(String text) {
        return Arrays.stream(text.split(" ")).filter(str -> str.length() > 4)
                .reduce(0, ((a, b) -> a + b.length()), Integer::sum);
    }

    public static int multiplicationOfNumbers(List<Integer> integers) {
        return integers.stream().reduce(1, ((integer, integer2) -> integer * integer2), (integer, integer2) -> integer * integer2);
    }

    public static <T extends Comparable<T>> T findMaxUsingReduce(List<T> elements) {
        return elements.stream()
                .reduce((a, b) -> a.compareTo(b) > 0 ? a : b)
                .orElse(null);
    }

    public static void main(String[] args) {
        String s = "12345 1234 123 123456";
        System.out.println(sumOfLettersInWordsLongerThanFour(s));
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(multiplicationOfNumbers(integers));

    }

}
