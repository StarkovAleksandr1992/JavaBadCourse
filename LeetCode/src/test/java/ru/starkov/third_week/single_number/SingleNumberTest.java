package ru.starkov.third_week.single_number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.single_number.SingleNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

    private SingleNumber singleNumber;

    @BeforeEach
    void setUp() {
        singleNumber = new SingleNumber();
    }

    @Test
    void singleNumberFirstTest() {
        int[] ints = {2, 2, 1};
        assertEquals(1, singleNumber.singleNumber(ints));
    }

    @Test
    void singleNumberSecondTest() {
        int[] ints = {4, 1, 2, 1, 2};
        assertEquals(4, singleNumber.singleNumber(ints));
    }

    @Test
    void singleNumberThirdTest() {
        int[] ints = {1};
        assertEquals(1, singleNumber.singleNumber(ints));
    }

    @Test
    void singleNumberFourthTest() {
        int[] ints = {1, 0, 1};
        assertEquals(0, singleNumber.singleNumber(ints));
    }
}