package ru.starkov.stream_api.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumer {
    public List<String> getStringContainsDigit() {
        return stringContainsDigit;
    }

    private List<String> stringContainsDigit = new ArrayList<>();
    public Consumer<Integer> integerConsumer = i -> {
        if (i % 2 == 0) {
            System.out.println(i);
        }
    };

    public Consumer<String> stringConsumer = s -> {
        char[] chars = s.toCharArray();
        for (Character character : chars) {
            if (Character.isDigit(character)) {
                stringContainsDigit.add(s);
            }
        }
    };


}
