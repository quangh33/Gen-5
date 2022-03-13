package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_876_MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val){ this.val = val; }
        ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode lowSpeedNode = head;
        ListNode fastSpeedNode = head;
        while (fastSpeedNode != null && fastSpeedNode.next != null){
            lowSpeedNode = lowSpeedNode.next;
            fastSpeedNode = fastSpeedNode.next.next;
        }
        return lowSpeedNode;
    }

    public void main() {
//        ListNode n5 = new ListNode(6);
        ListNode n4 = new ListNode(5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode head = new ListNode(1, n1);
        ListNode middle = middleNode(head);
        System.out.println("middle "+middle.val);
    }
}
