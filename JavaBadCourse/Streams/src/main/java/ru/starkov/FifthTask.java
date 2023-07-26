package ru.starkov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

public class FifthTask {

    public static Path findLargestFile(Path path) throws IOException {
        Optional<Path> max = Files.list(path).filter(Files::isRegularFile)
                .max(Comparator.comparingLong((Path path2) -> {
                    try {
                        return Files.size(path2);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }));
        return max.orElseThrow(RuntimeException::new);
    }
}
