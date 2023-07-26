package ru.starkov.second_week.diameter_of_binary_tree;

import ru.starkov.util.TreeNode;

import java.util.Stack;
import java.util.TreeSet;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int leftRadius = 0;
            int rightRadius = 0;
            if (current.left != null) {
                leftRadius = depth(current.left);
                stack.push(current.left);
            }
            if (current.right != null) {
                rightRadius = depth(current.right);
                stack.push(current.right);
            }
            treeSet.add(leftRadius + rightRadius);
        }
        return treeSet.last();
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
