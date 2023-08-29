package ru.starkov.third_week.move_zeroes;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == 0 && nums[right] != 0) {
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
                right++;
            } else if (nums[left] == 0 && nums[right] == 0) {
                right++;
            } else if (nums[left] != 0 && nums[right] == 0) {
                left++;
            } else if (nums[left] != 0 && nums[right] != 0) {
                left = right + 1;
                right += 2;
            } else {
                return;
            }
        }
    }
}
