using System;

namespace HammingWeight
{
    public class HammingWeight
    {
        public int HammingWeight(uint n)
        {
            return Convert.ToString(n, 2).Split('1').Length - 1;
        }
    }
}
