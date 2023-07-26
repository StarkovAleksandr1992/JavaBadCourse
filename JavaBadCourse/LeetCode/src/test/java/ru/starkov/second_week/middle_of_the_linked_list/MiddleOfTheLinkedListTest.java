package ru.starkov.second_week.middle_of_the_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.second_week.middle_of_the_linked_list.MiddleOfTheLinkedList;
import ru.starkov.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleOfTheLinkedListTest {

    private MiddleOfTheLinkedList middleOfTheLinkedList;
    @BeforeEach
    void setUp() {
        middleOfTheLinkedList = new MiddleOfTheLinkedList();
    }

    @Test
    void middleNode() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals("345", middleOfTheLinkedList.middleNode(head).toString());
    }

    @Test
    void nextMiddleNode() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        assertEquals("456", middleOfTheLinkedList.middleNode(head).toString());
    }
}