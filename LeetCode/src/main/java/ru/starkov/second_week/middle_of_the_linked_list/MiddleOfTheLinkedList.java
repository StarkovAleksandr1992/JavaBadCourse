package ru.starkov.second_week.middle_of_the_linked_list;


import ru.starkov.util.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
