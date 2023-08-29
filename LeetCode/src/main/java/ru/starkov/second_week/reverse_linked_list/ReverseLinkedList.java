package ru.starkov.second_week.reverse_linked_list;


import ru.starkov.util.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        if (head != null && head.next == null) {
            return head;
        } else {
            while (current != null) {
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }
        }
        return prev;
    }
}
