namespace LeetCodeSolutions
{
    public class MostFrequentSubtreeSum
    {
        private int Helper(TreeNode node, IDictionary<int, int> sum2Count)
        {
            if (node == null)
            {
                return 0;
            }

            int val = node.val;
            int leftSubtreeSum = Helper(node.left, sum2Count);
            int rightSubtreeSum = Helper(node.right, sum2Count);
            int sum = val + leftSubtreeSum + rightSubtreeSum;

            if (!sum2Count.ContainsKey(sum))
            {
                sum2Count[sum] = 0;
            }

            sum2Count[sum]++;
            return sum;
        }

        public int[] FindFrequentTreeSum(TreeNode root)
        {
            if (root == null)
            {
                return new int[0];
            }

            IDictionary<int, int> sum2Count = new Dictionary<int, int>();
            Helper(root, sum2Count);

            int maxCount = 0;
            IList<int> res = new List<int>();

            foreach (var s2c in sum2Count)
            {
                if (s2c.Value > maxCount)
                {
                    maxCount = s2c.Value;
                    res.Clear();
                }

                if (s2c.Value == maxCount)
                {
                    res.Add(s2c.Key);
                }
            }

            return res.ToArray();
        }
    }
}
