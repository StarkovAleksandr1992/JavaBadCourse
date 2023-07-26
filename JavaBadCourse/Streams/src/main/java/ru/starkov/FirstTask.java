package ru.starkov;

import java.util.List;

/**
 * Дан список целых чисел.
 * Найти среднее всех нечетных чисел , делящихся на 5 без остатка.
 */
public class FirstTask {

    public int findAvgOddNumbers(List<Integer> nums) {
        return (int) nums.stream().filter(i -> i % 5 == 0)
                .filter(integer -> integer % 2 != 0)
                .mapToInt(Integer::intValue)
                .summaryStatistics().getAverage();
    }
}
