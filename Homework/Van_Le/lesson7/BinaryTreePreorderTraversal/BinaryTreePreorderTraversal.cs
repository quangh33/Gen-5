namespace LeetCodeSolutions
{
    public class BinaryTreePreorderTraversal
    {
        public IList<int> PreorderTraversal(TreeNode root)
        {
            IList<int> output = new List<int>();

            TreeNode node = root;
            while (node != null)
            {
                if (node.left == null)
                {
                    output.Add(node.val);
                    node = node.right;
                }
                else
                {
                    TreeNode predecessor = node.left;
                    while ((predecessor.right != null) && (predecessor.right != node))
                    {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null)
                    {
                        output.Add(node.val);
                        predecessor.right = node;
                        node = node.left;
                    }
                    else
                    {
                        predecessor.right = null;
                        node = node.right;
                    }
                }
            }
            return output;
        }
    }
}
