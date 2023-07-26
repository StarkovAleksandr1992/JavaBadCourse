package ru.starkov;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FifthTaskTest {

    @Test
    void findLargestFileTest() {
        Path path = Path.of("\\Users\\Администратор\\Desktop\\Книги\\Грабер_Мартин_SQL_для_простых_смертных.pdf");
        Path largestFile = null;
        try {
            largestFile = FifthTask.findLargestFile(Path.of("\\Users\\Администратор\\Desktop\\Книги"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(path.getFileName(), largestFile.getFileName());
    }
}