using System.Linq;

namespace ProductArrayExceptSelf
{
    public static class ProductArrayExceptSelf
    {
        public static int[] ProductExceptSelf(int[] nums)
        {
            var product = 1;
            var numberOfZeroes = 0;
            var zeroTraverse = false;
            int[] result = new int[nums.Length];

            for (var i = 0; i < nums.Length; i++)
            {
                if (nums[i] != 0)
                {
                    product *= nums[i];
                }
                else
                {
                    zeroTraverse = true;
                    numberOfZeroes++;
                }
            }

            if (numberOfZeroes >= 2)
            {
                return result;
            }
            else if (zeroTraverse)
            {
                for (var i = 0; i < nums.Length; i++)
                {
                    if (nums[i] == 0)
                    {
                        result[i] = product;
                    }
                    else
                    {
                        result[i] = 0;
                    }
                }
                return result;
            }

            for (var i = 0; i < nums.Length; i++)
            {
                if (nums[i] != 0)
                {
                    result[i] = product / nums[i];
                }
            }
            return result;
        }
    }
}
