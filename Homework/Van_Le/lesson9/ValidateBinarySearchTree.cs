namespace LeetCodeSolutions
{
    public class ValidateBinarySearchTree
    {
        private int? prev;

        public bool IsValidBST(TreeNode root)
        {
            prev = null;
            return InOrder(root);
        }

        private bool InOrder(TreeNode root)
        {
            if (root == null)
            {
                return true;
            }
            if (!InOrder(root.left))
            {
                return false;
            }
            if (prev != null && root.val <= prev)
            {
                return false;
            }
            prev = root.val;
            return InOrder(root.right);
        }
    }
}
