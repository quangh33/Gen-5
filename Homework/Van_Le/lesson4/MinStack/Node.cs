namespace MinStack
{
    public class Node
    {
        public Node next;
        public int val;
        public int currentMin;
        public Node prev;
        public Node(int val = 0, int currentMin = int.MaxValue, Node prev = null, Node next = null)
        {
            this.val = val;
            this.currentMin = currentMin;
            this.next = next;
            this.prev = prev;
        }
    }
}
