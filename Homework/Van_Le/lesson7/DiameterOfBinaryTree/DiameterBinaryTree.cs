namespace LeetCodeSolutions
{
    public class DiameterBinaryTree
    {
        private int diameter;

        public int DiameterOfBinaryTree(TreeNode root)
        {
            diameter = 0;
            LongestPath(root);
            return diameter;
        }

        private int LongestPath(TreeNode node)
        {
            if (node == null) return 0;
            int leftPath = LongestPath(node.left);
            int rightPath = LongestPath(node.right);

            diameter = Math.Max(diameter, leftPath + rightPath);

            return Math.Max(leftPath, rightPath) + 1;
        }
    }
}
