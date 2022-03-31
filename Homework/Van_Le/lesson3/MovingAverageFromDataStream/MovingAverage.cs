using System.Collections.Generic;

namespace MovingAverage
{
    public class MovingAverage
    {
        private readonly int size;
        private int sum = 0;
        private readonly List<int> averageArray = new List<int>();
        public MovingAverage(int size)
        {
            this.size = size;
        }

        public double Next(int val)
        {
            averageArray.Add(val);
            var first = 0;
            if(averageArray.Count > size)
            {
                first = averageArray[0];
                averageArray.RemoveAt(0);
            }
            sum += val - first;
            return sum/(double)averageArray.Count;
        }
    }
}
