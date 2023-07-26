package ru.starkov.third_week.missing_number;

import java.util.Arrays;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if(nums[i] + 1 != nums[i + 1]) {
                    return nums[i] + 1;
                }
            }
            return nums[nums.length - 1] + 1;
        } else {
            return 0;
        }
    }
}
