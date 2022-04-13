public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (true) {
            if (slowPointer == null || fastPointer == null || fastPointer.next == null) break;
            fastPointer = fastPointer.next;
            if (slowPointer == fastPointer) {
                return true;
            }
            fastPointer = fastPointer.next;
            if (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
        }
        return false;
    }
}