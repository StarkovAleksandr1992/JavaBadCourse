package ru.starkov;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SeventhTaskTest {

    @Test
    void activeURLsTest() {
        List<URL> urls;
        try {
            urls = new ArrayList<>(List.of(new URL("https://ru.wikipedia.org"), new URL("https://www.google.com"),
                    new URL("https://www.coca-cola.com/kz/ru")));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(urls, SeventhTask.activeURLs(Path.of(".\\src\\main\\resources\\urls.txt")));
    }
}