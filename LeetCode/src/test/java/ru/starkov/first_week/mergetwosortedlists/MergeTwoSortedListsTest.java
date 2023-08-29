package ru.starkov.first_week.mergetwosortedlists;

import org.junit.jupiter.api.Test;
import ru.starkov.first_week.mergetwosortedlists.MergeTwoSortedLists;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {
    @Test
    void mergedList() {
        MergeTwoSortedLists.ListNode listNode = new MergeTwoSortedLists.ListNode(1);
        listNode.next = new MergeTwoSortedLists.ListNode(3);
        listNode.next.next = new MergeTwoSortedLists.ListNode(5);

        MergeTwoSortedLists.ListNode listNode1 = new MergeTwoSortedLists.ListNode(2);
        listNode1.next = new MergeTwoSortedLists.ListNode(3);
        listNode1.next.next = new MergeTwoSortedLists.ListNode(4);

        MergeTwoSortedLists.ListNode expected = new MergeTwoSortedLists.ListNode(1);
        expected.next = new MergeTwoSortedLists.ListNode(2);
        expected.next.next = new MergeTwoSortedLists.ListNode(3);
        expected.next.next.next = new MergeTwoSortedLists.ListNode(3);
        expected.next.next.next.next = new MergeTwoSortedLists.ListNode(4);
        expected.next.next.next.next.next = new MergeTwoSortedLists.ListNode(5);

        assertEquals(expected.toString(), MergeTwoSortedLists.mergeTwoLists(listNode, listNode1).toString());
    }
    @Test

    void mergedEmptyList() {
        MergeTwoSortedLists.ListNode listNode = null;

        MergeTwoSortedLists.ListNode listNode1 = new MergeTwoSortedLists.ListNode(1);

        MergeTwoSortedLists.ListNode expected = new MergeTwoSortedLists.ListNode(1);

        assertEquals(expected.toString(), MergeTwoSortedLists.mergeTwoLists(listNode, listNode1).toString());
    }
}