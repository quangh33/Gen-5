namespace MinStack
{
    public class MinStack
    {
        private ListNode head = null;

        public MinStack()
        {

        }

        public void Push(int val)
        {
            if (head == null)
            {
                head = new ListNode(val);
            }
            else
            {
                var temp = head;
                head = new ListNode(val);
                head.next = temp;
            }
        }

        public void Pop()
        {
            head = head.next;
        }

        public int Top()
        {
            return head.val;
        }

        public int GetMin()
        {
            var cursor = head;
            int minValue = int.MaxValue;
            while (cursor != null)
            {
                if (cursor.val < minValue)
                {
                    minValue = cursor.val;
                }
                cursor = cursor.next;
            }
            return minValue;
        }
    }
}
