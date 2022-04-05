namespace LeetCodeSolutions
{
    public class HouseRobberIII
    {
        Dictionary<TreeNode, int> robResult = new Dictionary<TreeNode, int>();
        Dictionary<TreeNode, int> notRobResult = new Dictionary<TreeNode, int>();

        public int Helper(TreeNode node, bool parentRobbed)
        {
            if (node == null)
            {
                return 0;
            }
            if (parentRobbed)
            {
                if (robResult.ContainsKey(node))
                {
                    return robResult[node];
                }
                int result = Helper(node.left, false) + Helper(node.right, false);
                robResult[node] = result;
                return result;
            }
            else
            {
                if (notRobResult.ContainsKey(node))
                {
                    return notRobResult[node];
                }
                int rob = node.val + Helper(node.left, true) + Helper(node.right, true);
                int notRob = Helper(node.left, false) + Helper(node.right, false);
                int result = Math.Max(rob, notRob);
                notRobResult[node] = result;
                return result;
            }
        }

        public int Rob(TreeNode root)
        {
            return Helper(root, false);
        }
    }
}
