namespace LeetCodeSolutions
{
    public class TheLongestUnivaluePath
    {
        private int longestPath = 0;
        public int LongestUnivaluePath(TreeNode root)
        {
            GetLongestPath(root);
            return longestPath;
        }

        private int GetLongestPath(TreeNode root)
        {
            if (root == null) return 0;
            int left = GetLongestPath(root.left);
            int right = GetLongestPath(root.right);

            int curPath = 0, leftMax = 0, rtMax = 0;
            if (root.left != null && root.left.val == root.val)
            {
                leftMax = ++left;
                curPath = leftMax;
            }
            if (root.right != null && root.right.val == root.val)
            {
                rtMax = ++right;
                curPath += rtMax;
            }
            // Update Global Max
            longestPath = Math.Max(longestPath, curPath);

            return Math.Max(leftMax, rtMax);
        }
    }
}
