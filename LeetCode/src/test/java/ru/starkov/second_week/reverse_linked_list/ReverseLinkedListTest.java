package ru.starkov.second_week.reverse_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.reverse_linked_list.ReverseLinkedList;
import ru.starkov.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    @BeforeEach
    void setUp() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    void reverseList() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals("54321", reverseLinkedList.reverseList(head).toString());
    }

    @Test
    void reverseShortList() {
        ListNode head = new ListNode(1, new ListNode(2));
        assertEquals("21", reverseLinkedList.reverseList(head).toString());
    }
}