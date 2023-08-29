package ru.starkov.first_week.lcaofbst;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if (currentNode.val == p.val || currentNode.val == q.val) {
                if (currentNode.left != null) {
                    if (findNode(currentNode.left, p, q)) {
                        return currentNode;
                    }
                }
                if (currentNode.right != null) {
                    if (findNode(currentNode.right, p, q)) {
                        return currentNode;
                    }
                }
            }
            if (currentNode.left != null && currentNode.right != null) {
                if (findNode(currentNode.left, p, q) && findNode(currentNode.right, p, q)) {
                    return currentNode;
                }
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return null;
    }
    private static boolean findNode(TreeNode node, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();

            if (currentNode.val == p.val || currentNode.val == q.val) {
                return true;
            }
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return false;
    }
}
