namespace MinStack
{
    public class MinStack
    {
        private int currentMin;
        private Node head, tail;
        private int NodeCount;

        public MinStack()
        {
			currentMin = int.MaxValue;
            head = new Node();
            tail = head;
            NodeCount = 0;
        }

        public void Push(int value)
        {
            NodeCount++;
            if (value < currentMin)
            {
                currentMin = value;
            }
            if (NodeCount == 1)
            {
                tail.val = value;
                tail.currentMin = currentMin;
            }
            else
            {
                tail.next = new Node(value, currentMin, tail);
                tail = tail.next;
            }
        }

        public void Pop()
        {
            NodeCount--;
            if (NodeCount > 0)
            {
                tail = tail.prev;
                currentMin = tail.currentMin;
            }
            else
            {
                currentMin = int.MaxValue;
                tail.currentMin = currentMin;
            }
        }

        public int Top()
        {
            return tail.val;
        }

        public int GetMin()
        {
            return tail.currentMin;
        }
    }
}
