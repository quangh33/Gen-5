class ReverseLinkedList_Recursion {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}