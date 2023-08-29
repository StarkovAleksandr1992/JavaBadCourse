package ru.starkov.second_week.diameter_of_binary_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.diameter_of_binary_tree.DiameterOfBinaryTree;
import ru.starkov.util.BinaryTreeBuilder;
import ru.starkov.util.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiameterOfBinaryTreeTest {

    private DiameterOfBinaryTree diameterOfBinaryTree;
    private BinaryTreeBuilder binaryTreeBuilder;

    @BeforeEach
    void setUp() {
        diameterOfBinaryTree = new DiameterOfBinaryTree();
        binaryTreeBuilder = new BinaryTreeBuilder();
    }

    @Test
    void diameterOfBinaryTree() {
        Integer[] tree = {1, 2, 3, 4, 5};
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        assertEquals(3, diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }

    @Test
    void diameterOfBinaryTreeSecond() {
        Integer[] tree = {1, 2};
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        assertEquals(1, diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }

    @Test
    void diameterOfBinaryTreeThird() {
        Integer[] tree = {4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2};
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        assertEquals(8, diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }
}