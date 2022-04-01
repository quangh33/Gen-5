namespace SingleNumber
{
    public static class XorQueriesSubArray
    {
        public static int[] XorQueries(int[] arr, int[][] queries)
        {
            int[] res = new int[queries.Length];
            for (int i = 1; i < arr.Length; i++)
            {
                arr[i] = arr[i - 1] ^ arr[i];
            }
            for (int i = 0; i < queries.Length; i++)
            {
                int[] query = queries[i];
                res[i] = (query[0] == 0 ? arr[query[1]] : arr[query[0] - 1] ^ arr[query[1]]);
            }
            return res;
        }
    }
}
