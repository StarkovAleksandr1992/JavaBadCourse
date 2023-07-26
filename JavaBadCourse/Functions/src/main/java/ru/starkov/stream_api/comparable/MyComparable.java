package ru.starkov.stream_api.comparable;

import java.util.Arrays;

public class MyComparable<T> {

    public <T extends Comparable<T>> T findMax(T[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }
}
