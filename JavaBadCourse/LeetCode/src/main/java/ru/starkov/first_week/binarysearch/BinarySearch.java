package ru.starkov.first_week.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = ((right + left) / 2);
            if (target == nums[index]) {
                return index;
            } else if (target > nums[index]) {
                left = index + 1;
            } else if (target < nums[index]) {
                right = index - 1;
            }
        }
        return -1;
    }
}
