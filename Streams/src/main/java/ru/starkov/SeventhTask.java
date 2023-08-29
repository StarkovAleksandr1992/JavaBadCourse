package ru.starkov;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeventhTask {

    public static List<URL> activeURLs(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(String::strip)
                    .map(spec -> {
                        try {
                            return new URL(spec);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .filter(url -> {
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            int responseCode = httpURLConnection.getResponseCode();
                            httpURLConnection.disconnect(); // Отключение соединения после получения кода ответа
                            return responseCode == 200;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
