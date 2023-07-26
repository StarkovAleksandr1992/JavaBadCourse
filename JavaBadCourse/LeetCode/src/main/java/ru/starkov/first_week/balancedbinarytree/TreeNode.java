package ru.starkov.first_week.balancedbinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
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

