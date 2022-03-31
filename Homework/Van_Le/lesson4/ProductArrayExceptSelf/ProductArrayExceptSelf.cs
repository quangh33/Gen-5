using System.Linq;

namespace ProductArrayExceptSelf
{
    public class ProductArrayExceptSelf
    {
        public int[] ProductExceptSelf(int[] nums)
        {
            int length = nums.Length;
            int [] result = new int[length];

            if (length == 1)
            {
                return result;
            }
            int i, temp = 1;

            result[0] = 1;

            for (i = 1; i < length; i++)
            {
                result[i] = temp;
                temp *= nums[i];
            }

            temp = 1;

            for (i = length - 1; i >= 0; i--)
            {
                result[i] *= temp;
                temp *= nums[i];
            }

            return result;
        }
    }
}
