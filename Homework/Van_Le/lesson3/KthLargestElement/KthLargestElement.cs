using System;

namespace KthLargestElement
{
    public class KthLargestElement
    {
        private Random random = new Random();

        public int FindKthLargest(int[] numbers, int pivotInput)
        {
            int left = 0, right = numbers.Length - 1;
            while (true)
            {
                int pivot = FindKthLargest(numbers, left, right);
                if (pivot == pivotInput - 1) return numbers[pivot];

                if (pivot < pivotInput - 1)
                {
                    left = pivot + 1;
                }
                else
                {
                    right = pivot - 1;
                }
            }
        }

        private int FindKthLargest(int[] numbers, int left, int right)
        {

            if (left == right) return left;
            int pivot = left + random.Next(right - left + 1);
            Swap(ref numbers[pivot], ref numbers[right]);
            pivot = right;

            int current = left;
            for (int i = left; i < right; i++)
            {

                if (numbers[i] >= numbers[pivot])
                {
                    Swap(ref numbers[i], ref numbers[current++]);
                }
            }

            Swap(ref numbers[pivot], ref numbers[current]);
            return current;

        }

        private void Swap(ref int leftNumber, ref int rightNumber)
        {
            int temp = leftNumber;
            leftNumber = rightNumber;
            rightNumber = temp;
        }
    }
}
