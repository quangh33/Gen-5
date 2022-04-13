namespace MiddleLinkedLisst
{
    public class MiddleLinkedLisst
    {
        public ListNode MiddleNode(ListNode head)
        {
            ListNode slowPointer = head;
            ListNode fastPointer = head;

            if(head != null)
            {
                while(fastPointer != null && fastPointer.next != null)
                {
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next.next;
                }
            }
            return slowPointer;
        }
    }
}
