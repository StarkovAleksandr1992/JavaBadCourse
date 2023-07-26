package ru.starkov.stream_api.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class MyPredicate {

    private char[] charToRemove;

    public MyPredicate() {
    }

    public MyPredicate(char[] charToRemove) {
        this.charToRemove = charToRemove;
    }

    public Predicate<String> startsWithLetterPredicate = (s -> s.startsWith("F"));

    public Predicate<String> startsWithArrayPredicate = s -> {
        for (char c : charToRemove) {
            if (s.charAt(0) == c) {
                return true;
            }
        }
        return false;
    };

    public Predicate<Cat> catPredicate = cat -> cat.getName().charAt(0) > 'b';
    public Predicate<Cat> catPredicate1 = cat -> cat.getAge() < 6;

    public BiPredicate<Integer, String> biPredicate = (i, s) -> i != s.length();


}
