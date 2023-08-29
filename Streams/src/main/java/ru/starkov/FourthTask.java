package ru.starkov;

import java.util.List;
import java.util.stream.Collectors;

public class FourthTask {

    public List<Integer> oddIntegers(List<Integer> integers) {
        return integers.stream().filter(integer -> integer % 2 != 0)
                .collect(Collectors.toList());
    }
}
