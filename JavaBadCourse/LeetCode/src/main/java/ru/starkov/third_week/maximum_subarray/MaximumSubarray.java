package ru.starkov.third_week.maximum_subarray;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int sumOfCurrentSubarray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfCurrentSubarray += nums[end++];
            if (maxSum < sumOfCurrentSubarray) {
                maxSum = sumOfCurrentSubarray;
            }
            if (sumOfCurrentSubarray < 0) {
                start = end;
                sumOfCurrentSubarray = 0;
                i = start - 1;
            }
        }
        return maxSum;
    }
}
