package ru.starkov.stream_api.comparator;

import ru.starkov.stream_api.predicate.Cat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparator {

    public Comparator<Cat> catComparator = Comparator.comparingInt(c -> c.getName().length());

    public Comparator<Integer> integerComparator = Comparator.comparingInt(Math::abs);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(-2);

        Integer closestToZero = findClosestToZero(numbers);
        System.out.println("Ближайшее к нулю число: " + closestToZero);  // Ближайшее к нулю число: 2
    }

    public static Integer findClosestToZero(List<Integer> numbers) {
        Comparator<Integer> closestToZeroComparator = Comparator.comparingInt(Math::abs);

        return Collections.min(numbers, closestToZeroComparator);
    }
}
