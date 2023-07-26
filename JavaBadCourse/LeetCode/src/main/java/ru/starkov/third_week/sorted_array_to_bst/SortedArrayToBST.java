package ru.starkov.third_week.sorted_array_to_bst;


import ru.starkov.util.TreeNode;

/**
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 */
public class SortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
       return createSubRoot(nums, 0, nums.length - 1);
    }

    public static TreeNode createSubRoot(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int indexOfSubRoot = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[indexOfSubRoot]);
        treeNode.left = createSubRoot(nums, left, indexOfSubRoot - 1);
        treeNode.right = createSubRoot(nums, indexOfSubRoot + 1, right);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(sortedArrayToBST(nums));
    }
}
