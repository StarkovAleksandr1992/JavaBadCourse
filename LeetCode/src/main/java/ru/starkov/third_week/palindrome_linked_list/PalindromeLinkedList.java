package ru.starkov.third_week.palindrome_linked_list;


import ru.starkov.util.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a
 * palindrome
 * or false otherwise.
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (head!=null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
