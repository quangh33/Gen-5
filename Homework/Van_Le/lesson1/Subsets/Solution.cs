namespace Subsets
{
    public static class Solution
    {
        public static IList<IList<int>> Subsets(int[] numbers)
        {
            IList<IList<int>> result = new List<IList<int>>();

            if (numbers == null || numbers.Length == 0)
                return result;

            result.Add(new List<int>());

            foreach (var number in numbers)
            {
                int currentResultCounting = result.Count;

                for (int i = 0; i < currentResultCounting; i++)
                    result.Add(new List<int>(result[i]) { number });
            }

            return result;
        }
    }
}
