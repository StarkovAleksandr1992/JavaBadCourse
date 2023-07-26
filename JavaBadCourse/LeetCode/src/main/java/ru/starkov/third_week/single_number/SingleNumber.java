package ru.starkov.third_week.single_number;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }
            if(stack.peek() == nums[i]) {
                stack.pop();
            }
        }
        return stack.pop();
    }
}
