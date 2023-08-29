package ru.starkov.second_week.maximum_depth_of_binary_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.maximum_depth_of_binary_tree.MaximumDepthOfBinaryTree;
import ru.starkov.util.BinaryTreeBuilder;
import ru.starkov.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree maxDepth;
    private BinaryTreeBuilder builder;


    @BeforeEach
    void setUp() {
        maxDepth = new MaximumDepthOfBinaryTree();
        builder = new BinaryTreeBuilder();
    }

    @Test
    void maxDepth() {
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

        assertEquals(5, maxDepth.maxDepth(root));
    }

    @Test
    void maxDepthSecond() {
        Integer[] tree = new Integer[] {0,2,4,1,null,3,-1,5,1,null,6,null,8};
        TreeNode treeNode = builder.buildTree(tree);
        assertEquals(4, maxDepth.maxDepth(treeNode));
    }
}