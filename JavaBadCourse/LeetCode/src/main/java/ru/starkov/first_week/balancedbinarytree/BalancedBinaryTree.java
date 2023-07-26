package ru.starkov.first_week.balancedbinarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is
 * height-balanced (A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.)
 */
public class BalancedBinaryTree {

    /*
     *Дерево сбалансировано при следующих услвоиях:
     * 1. Когда у каждого из узлов глубина отличается не больше чем на 1.
     * Для каждого узла нужно вычсислить глубину левого и правого листа.
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            int depthLeft = 0;
            int depthRight = 0;

            if (current.left != null) {
                queue.add(current.left);
                depthLeft = depth(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
                depthRight = depth(current.right);
            }
            if (Math.abs(depthLeft - depthRight) > 1) {
                return false;
            }
        }
        return true;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0; // Для пустого дерева глубина равна 0
        }

        int leftDepth = depth(node.left); // Рекурсивно вычисляем глубину левого поддерева
        int rightDepth = depth(node.right); // Рекурсивно вычисляем глубину правого поддерева

        // Глубина дерева равна максимуму из глубин левого и правого поддеревьев, плюс 1 (уровень текущего узла)
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
