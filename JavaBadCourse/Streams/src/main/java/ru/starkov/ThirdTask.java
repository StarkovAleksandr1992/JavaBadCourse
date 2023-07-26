package ru.starkov;

import ru.starkov.util.Cat;

import java.util.Comparator;
import java.util.List;

public class ThirdTask {

    public String longestName(List<Cat> cats) {
        return cats.stream().map(Cat::getName)
                .max(Comparator.comparingInt(String::length)).get();
    }


}
