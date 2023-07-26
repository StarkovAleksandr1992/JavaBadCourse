package ru.starkov.third_week.maximum_subarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.maximum_subarray.MaximumSubarray;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    private MaximumSubarray maximumSubarray;

    @BeforeEach
    void setUp() {
        maximumSubarray = new MaximumSubarray();
    }

    @Test
    void maxSubArrayFirstTest() {
        int ans = 6;
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(ans, maximumSubarray.maxSubArray(nums));
    }

    @Test
    void maxSubArraySecondTest() {
        int ans = 1;
        int[] nums = {1};
        assertEquals(ans, maximumSubarray.maxSubArray(nums));
    }

    @Test
    void maxSubArrayThirdTest() {
        int ans = 23;
        int[] nums = {5, 4, -1, 7, 8};
        assertEquals(ans, maximumSubarray.maxSubArray(nums));
    }

    @Test
    void maxSubArrayFourthTest() {
        int ans = -1;
        int[] nums = {-1};
        assertEquals(ans, maximumSubarray.maxSubArray(nums));
    }

    @Test
    void maxSubArrayFifthTest() {
        int ans = 1;
        int[] nums = {-2, 1};
        assertEquals(ans, maximumSubarray.maxSubArray(nums));
    }
}