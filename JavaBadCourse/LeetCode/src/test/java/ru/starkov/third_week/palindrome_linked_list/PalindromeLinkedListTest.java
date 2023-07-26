package ru.starkov.third_week.palindrome_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.starkov.third_week.palindrome_linked_list.PalindromeLinkedList;
import ru.starkov.util.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

    private PalindromeLinkedList palindromeLinkedList;
    @BeforeEach
    void setUp() {
        palindromeLinkedList = new PalindromeLinkedList();
    }

    @Test
    void itsPalindrome() {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        assertTrue(palindromeLinkedList.isPalindrome(listNode));
    }
    @Test
    void itsPalindromeSecondTest() {
        ListNode listNode = new ListNode(1, new ListNode(0, new ListNode(1)));
        assertTrue(palindromeLinkedList.isPalindrome(listNode));
    }



        @Test
    void itsNotPalindrome() {
        ListNode listNode = new ListNode(1, new ListNode(2));
        assertFalse(palindromeLinkedList.isPalindrome(listNode));
    }

    @Test
    void itsNotPalindromeSecondTest() {
        ListNode listNode = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(1)))));
        assertFalse(palindromeLinkedList.isPalindrome(listNode));
    }
}