package ru.starkov.third_week.subtree_of_another_tree;

import org.junit.jupiter.api.Test;
import ru.starkov.util.BinaryTreeBuilder;
import ru.starkov.util.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SubtreeOfAnotherTreeTest {

    @Test
    public void should_be_subtree() {
        Integer[] tree = {3, 4, 5, 1, 2};
        Integer[] subtree = {4, 1, 2};
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder();
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        TreeNode treeNode1 = binaryTreeBuilder.buildTree(subtree);
        assertTrue(SubtreeOfAnotherTree.isSubtree(treeNode, treeNode1));
    }

    @Test
    public void should_not_be_subtree() {
        Integer[] tree = {3,4,5,1,2,null,null,null,null,0};
        Integer[] subtree = {4,1,2};
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder();
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        TreeNode treeNode1 = binaryTreeBuilder.buildTree(subtree);
        assertFalse(SubtreeOfAnotherTree.isSubtree(treeNode, treeNode1));
    }

    @Test
    public void should_be_subtree_second() {
        Integer[] tree = {1,1};
        Integer[] subtree = {1};
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder();
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        TreeNode treeNode1 = binaryTreeBuilder.buildTree(subtree);
        assertTrue(SubtreeOfAnotherTree.isSubtree(treeNode, treeNode1));
    }

    @Test
    public void should_not_be_subtree_second() {
        Integer[] tree = {-1,-4,8,-6,-2,3,9,null,-5,null,null,0,7};
        Integer[] subtree = {3,0,5848};
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder();
        TreeNode treeNode = binaryTreeBuilder.buildTree(tree);
        TreeNode treeNode1 = binaryTreeBuilder.buildTree(subtree);
        assertFalse(SubtreeOfAnotherTree.isSubtree(treeNode, treeNode1));
    }

}