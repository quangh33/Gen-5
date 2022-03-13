package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_206_ReverseLinkedList {

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

    public ListNode reverseListByIterator(ListNode headNode) {
        ListNode previousNode = null;
        while (headNode != null && headNode.next != null) { // headNode = 1 // headNode = 3 // headNode = 5
            ListNode next = headNode.next; //2  //4 (//6)
            ListNode far = next.next;   // 3 //5 (// null)
            headNode.next = previousNode; // 1>null // 3>2>1>null (// 5>4>3>2>1>null)
            next.next = headNode; // 2>1>null //4>3>2>1>null (// 6>5>4>3>2>1>null)
            previousNode = next; // previousNode = 2 // previousNode = 4 (//previousNode = 6)
            headNode = far; // headNode = 3 // h = 5 (// h = null)
        }
        if(headNode != null){
            headNode.next = previousNode;
            return headNode;
        }
        return previousNode;
    }

    public ListNode reverseListByRecursive(ListNode headNode) {
        ListNode previousNode = null;
        ListNode res = recursive(headNode, previousNode);
        return res;
    }

    public ListNode recursive(ListNode headNode, ListNode previousNode) {
        if(headNode == null)    return previousNode;
        if(headNode.next == null){
            headNode.next = previousNode;
            return headNode;
        }
        ListNode next = headNode.next; //2  //4 (//6)
        ListNode far = next.next;   // 3 //5 (// null)
        headNode.next = previousNode; // 1>null // 3>2>1>null (// 5>4>3>2>1>null)
        next.next = headNode; // 2>1>null //4>3>2>1>null (// 6>5>4>3>2>1>null)
        previousNode = next; // previousNode = 2 // previousNode = 4 (//previousNode = 6)
        headNode = far;
        return recursive(headNode, previousNode);
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.print(""+head.val+"->");
            head= head.next;
        }
        System.out.println();
    }

    public void main() {
        ListNode n5 = new ListNode(6);
        ListNode n4 = new ListNode(5, n5);
        ListNode n3 = new ListNode(4, n4);
        ListNode n2 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode head = new ListNode(1, n1);
//        ListNode newHead = reverseListByIterator(head);
        ListNode newHead = reverseListByRecursive(head);
        print(newHead);
    }
}
