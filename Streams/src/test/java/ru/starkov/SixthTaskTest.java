package ru.starkov;

import org.junit.jupiter.api.Test;
import ru.starkov.util.Cat;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SixthTaskTest {

    @Test
    void removeWordsLongerThanFive() {
        String string = "12345 123456 123 123 1";
        String ans = "12345 123 123 1";
        assertEquals(ans, SixthTask.removeWordsLongerThanFive(string));
    }

    @Test
    void removeNotEnglishCharacters() {
        String string = "123 Привет";
        String ans = " ";
        assertEquals(ans, SixthTask.removeNonEnglishCharacters(string));
    }

    @Test
    void removeCatsWeightLessThanThree() {
        List<Cat> cats = Cat.cats;
        List<Cat> ans = new ArrayList<>(List.of(new Cat("Barsik", 3,3), new Cat("Murka", 9, 4),
                new Cat("Skoda", 14, 4)));
        assertEquals(ans, SixthTask.removeCatsWeightLessThanThree(cats));
    }

    @Test
    void groupingStringsByTag() {
        List<String> strings = new ArrayList<>();
        strings.add("ru.starkov");
        strings.add("org.projectlombok");
        Path path = Path.of("..\\Streams\\pom.xml");
        assertEquals(strings, SixthTask.groupingStringsByTag(path));
    }
}