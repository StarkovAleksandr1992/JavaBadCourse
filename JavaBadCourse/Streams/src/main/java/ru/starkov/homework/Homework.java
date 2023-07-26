package ru.starkov.homework;

import lombok.NonNull;
import ru.starkov.util.Man;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
    }

    public static <T> long countObject(@NonNull Collection<T> collection, @NonNull T element) {
        return collection.stream().filter(o -> o.equals(element)).count();
    }

    /**
     * @param collection @NonNull
     * @param <T>
     * @return Returns the first element of collection
     */
    public static <T> T getFirst(Collection<T> collection) {
        Objects.requireNonNull(collection);
        return collection.stream().findFirst().orElse(null);
    }

    public static <T> T getLast(Collection<T> collection) {
        return collection.stream().skip(collection.size() == 0 ? 0 : collection.size() - 1).findAny().orElse(null);
    }

    public static <T> boolean contains(Collection<T> collection, T element) {
        return collection.stream().anyMatch(o -> o.equals(element));
    }

    public static <T> T getByPosition(Collection<T> collection, long position) {
        if (position <= 0) {
            throw new IllegalArgumentException("Position must be greater than zero");
        }
        if (position > collection.size()) {
            throw new IllegalArgumentException("position must be less than collection size");
        }
        return collection.stream().skip(position - 1).findFirst().get();
    }

    public static List<Man> liableForMilitaryService(Collection<Man> collection) {
        return collection.stream().filter(Man::isLiableForMilitaryService).collect(Collectors.toList());
    }

    public static int averageAge(Collection<Man> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        if (collection.isEmpty()) {
            return 0;
        }
        return (int) collection.stream().mapToInt(Man::getAge).average().getAsDouble();
    }

    public static Collection<?> collectionOfUniqueElements(Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must mot be null or empty");
        }
        if (collection.isEmpty()) {
            return Collections.emptyList();

        }
        return collection.stream().distinct().collect(Collectors.toList());
    }
}
