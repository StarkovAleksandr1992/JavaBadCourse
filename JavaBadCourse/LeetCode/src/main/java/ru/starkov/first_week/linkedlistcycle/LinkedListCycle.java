package ru.starkov.first_week.linkedlistcycle;


import java.util.HashMap;
import java.util.Objects;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        HashMap<Integer, VisitFlag> map = new HashMap<>();
        while (head != null) {
            if (map.isEmpty()) {
                map.put(head.val, new VisitFlag(head, true));
                head = head.next;
                continue;
            }
            if (map.containsKey(head.val)) {
                VisitFlag visitFlag = map.get(head.val);
                if (visitFlag.getNode().next.val == head.next.val) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class VisitFlag {
        private ListNode node;
        private boolean flag = false;

        public VisitFlag(ListNode node, boolean flag) {
            this.node = node;
            this.flag = flag;
        }

        public ListNode getNode() {
            return node;
        }

        public boolean isFlag() {
            return flag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitFlag visitFlag = (VisitFlag) o;
            return flag == visitFlag.flag && Objects.equals(node, visitFlag.node);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, flag);
        }
    }

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
