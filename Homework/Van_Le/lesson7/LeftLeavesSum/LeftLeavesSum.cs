namespace LeetCodeSolutions
{
    public static class LeftLeavesSum
    {
        public static int SumOfLeftLeaves(TreeNode root)
        {
            int totalSum = 0;
            TreeNode currentNode = root;
            while (currentNode != null)
            {
                if (currentNode.left == null)
                {
                    currentNode = currentNode.right;
                }
                else
                {
                    TreeNode previous = currentNode.left;
                    if (previous.left == null && previous.right == null)
                    {
                        totalSum += previous.val;
                    }
                    while (previous.right != null && !previous.right.Equals(currentNode))
                    {
                        previous = previous.right;
                    }
                    if (previous.right == null)
                    {
                        previous.right = currentNode;
                        currentNode = currentNode.left;
                    }
                    else
                    {
                        previous.right = null;
                        currentNode = currentNode.right;
                    }
                }
            }
            return totalSum;
        }
    }
}
