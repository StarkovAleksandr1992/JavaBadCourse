package ru.starkov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstTaskTest {

    private FirstTask firstTask;

    @BeforeEach
    void setUp() {
        firstTask = new FirstTask();
    }

    @Test
    void findAvgOddNumbers() {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        int avgOddNumbers = firstTask.findAvgOddNumbers(nums);
        assertEquals(5, avgOddNumbers);
    }
}