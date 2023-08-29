package ru.starkov.stream_api.unary_operator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MyUnaryOperator {

    public UnaryOperator<Integer> integerUnaryOperator = i -> {
        if (i % 2 != 0) {
            i = 0;
        }
        return i;
    };

    public UnaryOperator<String> stringUnaryOperator = s -> {
        String s1 = s.replaceAll("[a-zA-Z\\W]", "");
        return s1;
    };

    public UnaryOperator<List<String>> listUnaryOperator = list -> {
        List<String> longWordsList = new ArrayList<>();
        for (String s : list) {
            if (s.length() > 5) {
                longWordsList.add(s);
            }
        }
        return longWordsList;
    };

}
