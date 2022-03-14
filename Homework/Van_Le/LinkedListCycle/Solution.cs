namespace LinkedListCycle
{
    public class LinkedListCycle
    {
        public bool HasCycle(ListNode head)
        {
            ListNode slowPointer = head;
            ListNode fastPointer = head;
            while (fastPointer != null && fastPointer.next != null)
            {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
                if (slowPointer == fastPointer) { return true; }
            }
            return false;
        }
    }
}
