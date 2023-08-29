package ru.starkov.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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
