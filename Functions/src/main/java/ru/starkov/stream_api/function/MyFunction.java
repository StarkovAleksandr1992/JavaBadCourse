package ru.starkov.stream_api.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyFunction {

    public Predicate<Integer> predicate = (number) -> {
        if (number < 2) {
            return false;
        }
        for (int j = 2; j * j <= number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    };
    public Function<Integer[], Integer> function = (integers) -> {
        long count = Arrays.stream(integers).filter(predicate).count();
        return (int) count;
    };

    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction();
        Integer[] integers = {1,2,3,4, 5, 6, 8, 7,13};
        Integer apply = myFunction.function.apply(integers);
        System.out.println(apply);
    }

    public Function<String, char[]> stringFunction = String::toCharArray;
    public Function<char[], Integer> integerFunction = chars -> {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i];
        }
        return sum;
    };

    public Function<String, Integer> sumCodesOfChars = stringFunction.andThen(integerFunction);

    public BiFunction<String, String, List<String>> stringStringBiFunction = (s1, s2) -> {
        String[] arrayS1 = s1.split(" ");
        String[] arrayS2 = s2.split(" ");
        List<String> stringList = new ArrayList<>();
        for (String string1 : arrayS1) {
            for (String string2 : arrayS2) {
                if (string1.equals(string2)) {
                    stringList.add(string1);
                }
            }
        }
        return stringList;
    };

}
