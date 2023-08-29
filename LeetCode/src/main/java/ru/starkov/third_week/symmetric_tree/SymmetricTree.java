package ru.starkov.third_week.symmetric_tree;


import ru.starkov.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null && root.right != null) {
            if (root.left.val != root.right.val) {
                return false;
            }

            Queue<TreeNode> leftSubtree = new ArrayDeque<>();
            Queue<TreeNode> rightSubtree = new ArrayDeque<>();
            leftSubtree.add(root.left);
            rightSubtree.add(root.right);

            while (!leftSubtree.isEmpty() || !rightSubtree.isEmpty()) {
                TreeNode currentLeft = leftSubtree.poll();
                TreeNode currentRight = rightSubtree.poll();

                if ((currentLeft.left != null && currentRight.right == null) ||
                        (currentLeft.left == null && currentRight.right != null) ||
                        (currentLeft.left != null && currentRight.right != null &&
                                currentLeft.left.val != currentRight.right.val)) {
                    return false;
                }

                if ((currentLeft.right != null && currentRight.left == null) ||
                        (currentLeft.right == null && currentRight.left != null) ||
                        (currentLeft.right != null && currentRight.left != null &&
                                currentLeft.right.val != currentRight.left.val)) {
                    return false;
                }

                if (currentLeft.left != null) {
                    leftSubtree.add(currentLeft.left);
                }
                if (currentRight.right != null) {
                    rightSubtree.add(currentRight.right);
                }
                if (currentLeft.right != null) {
                    leftSubtree.add(currentLeft.right);
                }
                if (currentRight.left != null) {
                    rightSubtree.add(currentRight.left);
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
