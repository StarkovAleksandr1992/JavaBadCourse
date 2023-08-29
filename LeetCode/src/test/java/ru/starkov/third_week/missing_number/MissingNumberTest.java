package ru.starkov.third_week.missing_number;

import ru.starkov.third_week.missing_number.MissingNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MissingNumberTest {

    private MissingNumber missingNumber;

    @BeforeEach
    void setUp() {
        missingNumber = new MissingNumber();
    }

    @Test
    void missingNumberFirstTest() {
        int[] nums = {3, 0, 1};
        assertEquals(2, missingNumber.missingNumber(nums));
    }

    @Test
    void missingNumberSecondTest() {
        int[] nums = {0, 1};
        assertEquals(2, missingNumber.missingNumber(nums));
    }

    @Test
    void missingNumberThirdTest() {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        assertEquals(8, missingNumber.missingNumber(nums));
    }
    @Test
    void missingNumberFourthTest() {
        int[] nums = {1,2};
        assertEquals(0, missingNumber.missingNumber(nums));
    }
}