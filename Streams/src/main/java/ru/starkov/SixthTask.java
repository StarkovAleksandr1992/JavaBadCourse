package ru.starkov;

import ru.starkov.util.Cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SixthTask {

    public static String removeWordsLongerThanFive(String text) {
        return Arrays.stream(text.split(" "))
                .filter(str -> str.length() <= 5)
                .collect(Collectors.joining(" "));
    }

    public static String removeNonEnglishCharacters(String text) {
        return text.chars()
                .filter(character -> (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z') || character == ' ')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static List<Cat> removeCatsWeightLessThanThree(List<Cat> cats) {
        return cats.stream().filter(cat -> cat.getWeight() >= 3)
                .sorted(Comparator.comparing(Cat::getName))
                .collect(Collectors.toList());
    }

    public static List<String> groupingStringsByTag(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return reader.lines()
                    .filter(s -> s.contains("<groupId>") && s.contains("</groupId>"))
                    .map(s -> s.substring(s.indexOf("<groupId>") + "<groupId>".length(), s.indexOf("</groupId>")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
