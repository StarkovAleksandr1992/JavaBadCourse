package ru.starkov.first_week.invertbinarytree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode result = root;
        TreeNode temp = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            temp = current.left;
            current.left = current.right;
            current.right = temp;
        }
        return result;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        @Override
        public String toString() {
            List<Integer> integers = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            TreeNode root = this;
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                integers.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : integers) {
                stringBuilder.append(integer);
            }
            return stringBuilder.toString();
        }
    }
}
