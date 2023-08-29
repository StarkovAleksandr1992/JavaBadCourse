package ru.starkov.first_week.invertbinarytree;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.invertbinarytree.InvertBinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvertBinaryTreeTest {

    @Test
    void invertTree() {
        InvertBinaryTree.TreeNode treeNode = new InvertBinaryTree.TreeNode(4, new InvertBinaryTree.TreeNode(2, new InvertBinaryTree.TreeNode(1), new InvertBinaryTree.TreeNode(3)),
                new InvertBinaryTree.TreeNode(7, new InvertBinaryTree.TreeNode(6), new InvertBinaryTree.TreeNode(9)));
    assertEquals("4729631", InvertBinaryTree.invertTree(treeNode).toString());
    }

    @Test
    void  invertEmptyTree() {

    }
}