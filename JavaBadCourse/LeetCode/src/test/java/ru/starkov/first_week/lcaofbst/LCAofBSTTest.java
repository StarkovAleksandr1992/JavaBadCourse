package ru.starkov.first_week.lcaofbst;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.starkov.first_week.lcaofbst.LCAofBST;
import ru.starkov.first_week.lcaofbst.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class LCAofBSTTest {



    @Test
    @Order(1)
    void lowestCommonAncestorFirstTest() {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node4.left = node3;
        node4.right = node5;
        node8.left = node7;
        node8.right = node9;

        assertEquals(2, new LCAofBST().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)).val);
    }
    @Test
    @Order(2)
    void lowestCommonAncestorSecondTest() {
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

        assertEquals(4, new LCAofBST().lowestCommonAncestor(root, new TreeNode(10), new TreeNode(3)).val);
    }
}