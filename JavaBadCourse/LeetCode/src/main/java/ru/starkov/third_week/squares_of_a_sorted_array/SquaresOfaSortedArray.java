package ru.starkov.third_week.squares_of_a_sorted_array;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfaSortedArray {

    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).mapToObj(integer -> (int) Math.pow(integer, 2)).sorted().mapToInt(Integer::intValue).toArray();
    }
}
