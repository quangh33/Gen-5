package HomeWorkLesson3;

import ListNode.ListNode;

import java.util.List;

public class SortListMergeSort {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle, leftPart, rightPart;
        middle = middleNode(head);
        rightPart = middle.next;
        leftPart = head;
        middle.next = null;
        leftPart = sortList(leftPart);
        rightPart = sortList(rightPart);
        return mergeListNode(leftPart, rightPart);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (true) {
            if (fastPointer.next == null || fastPointer.next.next == null) break;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public ListNode mergeListNode(ListNode listNode1, ListNode listNode2) {
        ListNode result = new ListNode(0) , resultPointer = result;
        while (true) {
            if (listNode1 == null || listNode2 == null ) break;
            if (listNode1.val < listNode2.val) {
                resultPointer.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                resultPointer.next = listNode2;
                listNode2 = listNode2.next;
            }
            resultPointer = resultPointer.next;
        }
        if (listNode1 != null) {
            resultPointer.next = listNode1;
        }
        if (listNode2 != null) {
            resultPointer.next = listNode2;
        }
        return result.next;
    }
}
