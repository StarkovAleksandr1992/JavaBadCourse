package ru.starkov.first_week.twosum;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.starkov.first_week.twosum.TwoSum;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoSumTest {

    @Test
    @Order(1)
    void test1TwoSum() {
        int[] nums = {1, 4, 6, 2, 3};
        int target = 8;
        int[] result1 = {2, 3};
        int[] result2 = {3, 2};
        int[] actual = TwoSum.twoSum(nums, target);
        assertTrue(Arrays.equals(result1, actual) ||
                Arrays.equals(result2, actual));
    }
    @Test
    @Order(2)
    void test2TwoSum() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result1 = {1, 2};
        int[] result2 = {2, 1};
        int[] actual = TwoSum.twoSum(nums, target);
        assertTrue(Arrays.equals(result1, actual) ||
                Arrays.equals(result2, actual));
    }

    @Test
    @Order(3)
    void test3TwoSum() {
        int[] nums = {3,3};
        int target = 6;
        int[] result1 = {0, 1};
        int[] result2 = {1, 0};
        int[] actual = TwoSum.twoSum(nums, target);
        assertTrue(Arrays.equals(result1, actual) ||
                Arrays.equals(result2, actual));
    }


    }