package ru.starkov.first_week.mergetwosortedlists;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode currentNode = new ListNode(-1);
        ListNode result = currentNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = new ListNode(list1.val);
                list1 = list1.next;
                currentNode = currentNode.next;
            } else {
                currentNode.next = new ListNode(list2.val);
                list2 = list2.next;
                currentNode = currentNode.next;
            }
        }
        if (list1 != null) {
            currentNode.next = list1;
        } else if (list2 != null) {
            currentNode.next = list2;
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode current = this;
            StringBuilder stringBuilder = new StringBuilder();

            while (current != null) {
                stringBuilder.append(current.val);
                current = current.next;
            }
            return stringBuilder.toString();
        }
    }
}
