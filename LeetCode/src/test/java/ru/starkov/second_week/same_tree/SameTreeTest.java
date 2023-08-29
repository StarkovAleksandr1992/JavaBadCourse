package ru.starkov.second_week.same_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.same_tree.SameTree;
import ru.starkov.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SameTreeTest {
    private SameTree sameTree;
    @BeforeEach
    void setUp() {
        sameTree = new SameTree();
    }

    @Test
    void itsSameTree() {
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

        TreeNode root1 = new TreeNode(6);
        TreeNode node21 = new TreeNode(2);
        TreeNode node81 = new TreeNode(8);
        TreeNode node01 = new TreeNode(0);
        TreeNode node41 = new TreeNode(4);
        TreeNode node71 = new TreeNode(7);
        TreeNode node91 = new TreeNode(9);
        TreeNode node31 = new TreeNode(3);
        TreeNode node51 = new TreeNode(5);
        TreeNode node101 = new TreeNode(10);
        TreeNode node111 = new TreeNode(11);

        root1.left = node21;
        root1.right = node81;
        node21.left = node01;
        node21.right = node41;
        node41.left = node31;
        node41.right = node51;
        node81.left = node71;
        node81.right = node91;
        node51.left = node101;
        node51.right = node111;

        assertTrue(sameTree.isSameTree(root, root1));

    }

    @Test
    void itsNotSameTree() {
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
        TreeNode node11 = new TreeNode(12);

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

        TreeNode root1 = new TreeNode(6);
        TreeNode node21 = new TreeNode(2);
        TreeNode node81 = new TreeNode(8);
        TreeNode node01 = new TreeNode(0);
        TreeNode node41 = new TreeNode(4);
        TreeNode node71 = new TreeNode(7);
        TreeNode node91 = new TreeNode(9);
        TreeNode node31 = new TreeNode(3);
        TreeNode node51 = new TreeNode(5);
        TreeNode node101 = new TreeNode(10);
        TreeNode node111 = new TreeNode(11);

        root1.left = node21;
        root1.right = node81;
        node21.left = node01;
        node21.right = node41;
        node41.left = node31;
        node41.right = node51;
        node81.left = node71;
        node81.right = node91;
        node51.left = node101;
        node51.right = node111;

        assertFalse(sameTree.isSameTree(root, root1));
    }
    @Test
    void itsNotSameTreeSecond() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        root.left = node2;

        TreeNode root1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);

        root1.right = node21;

        assertFalse(sameTree.isSameTree(root, root1));
    }
}