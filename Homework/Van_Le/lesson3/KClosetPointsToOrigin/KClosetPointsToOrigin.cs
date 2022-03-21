using System;
using System.Linq;

namespace KClosetPointsToOrigin
{
    public class KClosetPointsToOrigin
    {
        public int[][] KClosest(int[][] points, int k)
        {
            return points.OrderBy(p => Math.Sqrt(p[0] * p[0] + p[1] * p[1])).Take(k).ToArray();
        }
    }
}
