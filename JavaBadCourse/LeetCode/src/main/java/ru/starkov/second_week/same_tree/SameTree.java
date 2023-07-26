package ru.starkov.second_week.same_tree;


import ru.starkov.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }

        Queue<TreeNode> stackOfP = new ArrayDeque<>();
        Queue<TreeNode> stackOfQ = new ArrayDeque<>();

        stackOfP.add(p);
        stackOfQ.add(q);

        while (!stackOfP.isEmpty() || !stackOfQ.isEmpty()) {
            TreeNode currentP = stackOfP.remove();
            TreeNode currentQ = stackOfQ.remove();
            if (currentP.val != currentQ.val) {
                return false;
            } else {
                if (currentP.left != null && currentQ.left != null) {
                    stackOfP.add(currentP.left);
                    stackOfQ.add(currentQ.left);

                }
                if (currentP.right != null && currentQ.right != null) {
                    stackOfP.add(currentP.right);
                    stackOfQ.add(currentQ.right);

                }
                if (currentP.left == null && currentQ.left != null) {
                    return false;
                }
                if (currentP.left != null && currentQ.left == null) {
                    return false;
                }
                if (currentP.right == null && currentQ.right != null) {
                    return false;
                }
                if (currentP.right != null && currentQ.right == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
