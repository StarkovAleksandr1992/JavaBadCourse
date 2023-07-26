package ru.starkov.second_week.counting_bits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.counting_bits.CountingBits;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CountingBitsTest {

    private CountingBits countingBits;

    @BeforeEach
    void setUp() {
        countingBits = new CountingBits();
    }

    @Test
    void countBitsFirstTest() {
        int[] ans = {0, 1, 1};
        assertArrayEquals(ans, countingBits.countBits(2));
    }

    @Test
    void countBitsSecondTest() {
        int[] ans = {0, 1, 1, 2, 1, 2};
        assertArrayEquals(ans, countingBits.countBits(5));
    }
}