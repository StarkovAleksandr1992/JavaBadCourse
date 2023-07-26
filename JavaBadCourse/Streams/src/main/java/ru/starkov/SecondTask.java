package ru.starkov;

import java.util.List;

/**
 * Дан список строкю найти количество уникальных строк длиной более 12 символов.
 */
public class SecondTask {

    public int findUniqueStrings(List<String> strings) {
        return (int) strings.stream()
                .filter(str -> str.length() > 10)
                .distinct()
                .count();
    }
}
