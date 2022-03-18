namespace SortColors
{
    public static class Solution
    {
        public static void SortColors(int[] nums)
        {
            int red = 0, white = 0, blue = 0;

            for (int i = 0; i < nums.Length; i++)
            {
                switch (nums[i])
                {
                    case 0:
                        {
                            red++;
                            break;
                        }
                    case 1:
                        {
                            white++;
                            break;
                        }
                    case 2:
                        {
                            blue++;
                            break;
                        }
                    default:
                        {
                            break;
                        }
                }
            }

            int position = 0;
            for(; position < red; position++)
            {
                nums[position] = 0;
            }

            for(; position < white + red; position++)
            {
                nums[position] = 1;
            }

            for (; position < blue + white + red; position++)
            {
                nums[position] = 2;
            }
        }
    }
}
