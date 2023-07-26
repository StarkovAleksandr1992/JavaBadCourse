package ru.starkov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FourthTaskTest {

    private FourthTask fourthTask;

    @BeforeEach
    void setUp() {
        fourthTask = new FourthTask();
    }

    @Test
    void oddIntegersTest() {
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14));
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= 14; i++) {
            if (i % 2 != 0) {
                ans.add(i);
            }
        }
        assertEquals(ans, fourthTask.oddIntegers(integers));
    }
}