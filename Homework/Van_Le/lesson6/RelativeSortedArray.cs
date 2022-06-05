namespace LeetCodeSolutions
{
    public static class RelativeSortedArray
    {
        public static int[] RelativeSortArray(int[] arr1, int[] arr2)
        {
            var dict = new Dictionary<int, int>();
            for (var i = 0; i < arr2.Length; i++)
                dict.Add(arr2[i], i);

            for (var i = 0; i < arr1.Length - 1; i++)
            {
                for (var j = i + 1; j < arr1.Length; j++)
                {
                    var cond1 = dict.ContainsKey(arr1[i]);
                    var cond2 = dict.ContainsKey(arr1[j]);
                    if (cond1 && cond2)
                    {
                        if (dict[arr1[i]] > dict[arr1[j]])
                        {
                            Swap(arr1, i, j);
                        }
                    }
                    else if (!cond1 && !cond2)
                    {
                        if (arr1[i] > arr1[j])
                        {
                            Swap(arr1, i, j);
                        }
                    }
                    else if (!cond1 && cond2)
                    {
                        Swap(arr1, i, j);
                    }
                }
            }

            return arr1;
        }

        private static void Swap(int[] arr, int i, int j)
        {
            var tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
