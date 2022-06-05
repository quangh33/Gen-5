namespace LeetCodeSolutions
{
    public class TrimBinarySearchTree
    {
        public TreeNode TrimBst(TreeNode root, int low, int high)
        {
            if (root == null) return root;
            if (root.val > high) return TrimBst(root.left, low, high);
            if (root.val < low) return TrimBst(root.right, low, high);

            root.left = TrimBst(root.left, low, high);
            root.right = TrimBst(root.right, low, high);
            return root;
        }
    }
}
