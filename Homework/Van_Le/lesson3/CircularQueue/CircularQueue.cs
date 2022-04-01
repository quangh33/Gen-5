using System.Collections.Generic;

namespace CircularQueue
{
    public class CircularQueue
    {
        private int size, front, rear;
        private readonly List<int> resultList = new List<int>();
        public CircularQueue(int k)
        {
            this.size = k;
            this.front = -1;
            this.rear = -1;
        }

        public bool EnQueue(int value)
        {
            if (resultList.Count < size)
            {
                resultList.Add(value);
                if (resultList.Count == 1)
                {
                    front = 0; rear = 0;
                }
                else rear++;
            }
            else return false;
            return true;
        }

        public bool DeQueue()
        {
            if (resultList.Count > 0)
            {
                resultList.RemoveAt(0);
                rear--;
            }
            else return false;
            return true;
        }

        public int Front()
        {
            if (resultList.Count == 0) return -1;
            else return resultList[0];
        }

        public int Rear()
        {
            if (resultList.Count == 0) return -1;
            else return resultList[rear];
        }

        public bool IsEmpty()
        {
            return resultList.Count == 0;
        }

        public bool IsFull()
        {
            return resultList.Count == size;
        }
    }
}
