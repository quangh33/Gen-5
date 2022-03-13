package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_141_LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode lowSpeedNode = head;
        ListNode fastSpeedNode = head;
        while (fastSpeedNode != null && fastSpeedNode.next != null) {
            lowSpeedNode = lowSpeedNode.next;
            fastSpeedNode = fastSpeedNode.next.next;
        }
        return lowSpeedNode;
    }

    public boolean hasCycle(ListNode head) {
        ListNode lowSpeedNode = head;
        ListNode fastSpeedNode = head;
        while (fastSpeedNode != null && fastSpeedNode.next != null) {
            lowSpeedNode = lowSpeedNode.next;
            fastSpeedNode = fastSpeedNode.next.next;
            if (lowSpeedNode == fastSpeedNode) return true;
        }
        return false;
    }

    public void main() {
        ListNode n5 = new ListNode(6);
        ListNode n4 = new ListNode(5, n5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode head = new ListNode(1, n1);
        n5.next = n2;
        boolean isCycle = hasCycle(head);
        System.out.println("isCycle " + isCycle);
    }
}
