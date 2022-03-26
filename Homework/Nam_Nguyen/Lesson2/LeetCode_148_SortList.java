package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_148_SortList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode n1 = head;
        ListNode middleListNode = getMiddleListNode(n1);
        ListNode n2 = middleListNode.next;
        middleListNode.next = null;

        ListNode left = sortList(n1);
        ListNode right = sortList(n2);
        ListNode merge = mergeList(left, right);

        return merge;
    }

    public ListNode getMiddleListNode(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;

        while(n1 != null && n2 != null){
            if(n2.next == null || n2.next.next == null){
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }

        return head;
    }

    public ListNode mergeList(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        ListNode p1 = n1;
        ListNode p2 = n2;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val) {
                result.next = p1;
                p1 = p1.next;
            }else {
                result.next = p2;
                p2 = p2.next;
            }
            result = result.next;
        }

        if(p1 != null){
            result.next = p1;
        }

        if(p2 != null){
            result.next = p2;
        }

        return head.next;

    }

    public void main() {
        LeetCode_148_SortList l = new LeetCode_148_SortList();
        ListNode n1  = l.new ListNode(1);
        ListNode n2  = l.new ListNode(2);
        ListNode n3  = l.new ListNode(7);
        ListNode n4  = l.new ListNode(8);
        ListNode n5  = l.new ListNode(3);
        ListNode n6  = l.new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode head = sortList(n1);
        print(head);
    }

    public void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
    
}
