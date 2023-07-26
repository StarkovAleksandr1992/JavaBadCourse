package ru.starkov.first_week.balancedbinarytree;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.balancedbinarytree.BalancedBinaryTree;
import ru.starkov.first_week.balancedbinarytree.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeTest {

    @Test
    void itsFirstFalseBalanced() {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);


        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;
        node5.left = node10;
        node5.right = node11;
        assertFalse(new BalancedBinaryTree().isBalanced(root));
    }

    @Test
    void itsFirstTrueBalanced() {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        assertTrue(new BalancedBinaryTree().isBalanced(root));

    }

    @Test
    void itsSecondFalseBalanced() {
        TreeNode root = new TreeNode(1);
        TreeNode node2a = new TreeNode(2);
        TreeNode node2b = new TreeNode(2);
        TreeNode node3a = new TreeNode(3);
        TreeNode node3b = new TreeNode(3);
        TreeNode node4a = new TreeNode(4);
        TreeNode node4b = new TreeNode(4);

        root.left = node2a;
        root.right = node2b;
        node2a.left = node3a;
        node2a.right = node3b;
        node3a.left = node4a;
        node3a.right = node4b;
        assertFalse(new BalancedBinaryTree().isBalanced(root));

    }
}