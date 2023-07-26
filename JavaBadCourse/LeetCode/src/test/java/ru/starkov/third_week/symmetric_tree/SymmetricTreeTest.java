package ru.starkov.third_week.symmetric_tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.symmetric_tree.SymmetricTree;
import ru.starkov.util.BinaryTreeBuilder;
import ru.starkov.util.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {
    private SymmetricTree symmetricTree;

    @BeforeEach
    void setUp() {
        symmetricTree = new SymmetricTree();
    }

    @Test
    void itsSymmetricFirstTest() {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        Integer[] tree = {1,2,2,3,4,4,3};
        TreeNode treeNode = builder.buildTree(tree);
        assertTrue(symmetricTree.isSymmetric(treeNode));
    }

    @Test
    void itsNotSymmetricFirstTest() {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        Integer[] tree = {1,2,2,null,3,null,3};
        TreeNode treeNode = builder.buildTree(tree);
        assertFalse(symmetricTree.isSymmetric(treeNode));
    }

    @Test
    void itsNotSymmetricSecondTest() {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        Integer[] tree = {2,3,3,4,5,5};
        TreeNode treeNode = builder.buildTree(tree);
        assertFalse(symmetricTree.isSymmetric(treeNode));
    }

    @Test
    void itsNotSymmetricThirdTest() {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        Integer[] tree = {7,-64,-64,-6,-90,-90,-6,88,-44,68,-65,-76,68,-44,88};
        TreeNode treeNode = builder.buildTree(tree);
        assertFalse(symmetricTree.isSymmetric(treeNode));
    }
}