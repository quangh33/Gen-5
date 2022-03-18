public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while(true){
            if(fastPointer == null || fastPointer.next == null) break;
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }
}
