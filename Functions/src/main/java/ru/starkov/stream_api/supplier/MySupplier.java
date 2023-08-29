package ru.starkov.stream_api.supplier;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySupplier implements Supplier<String> {

    private String string;
    private Queue<String> strings;

    private final List<String> stringList = new ArrayList<>(List.of("Hello", "world", "Java"));

    public MySupplier() {
    }

    public MySupplier(String string) {
        this.string = string;
        strings = new ArrayDeque<>(Arrays.asList(string.split(" ")));
    }

    @Override
    public String get() {
        if (strings.isEmpty()) {
            return "Новых слов больше нет";
        }
        return strings.remove();
    }

    Predicate<String> predicate = s -> {
        Pattern pattern = Pattern.compile("(?:[A-ZА-Я][a-zA-ZА-Яа-я]*)");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    };

    Supplier<String> supplier = () -> {
        stringList.removeIf(predicate.negate());
        if (stringList.isEmpty()) {
            return "больше нет слов";
        }
        return stringList.remove(0);
    };

    public static void main(String[] args) {
        MySupplier mySupplier = new MySupplier();
        System.out.println(mySupplier.supplier.get());
        System.out.println(mySupplier.supplier.get());
    }

}
