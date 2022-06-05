namespace LeetCodeSolutions
{
    public class InvertBST
    {
        public TreeNode InvertTree(TreeNode root)
        {
            if (root == null) return root;

            var temp = root.left;
            root.left = root.right;
            root.right = temp;

            InvertTree(root.left);
            InvertTree(root.right);

            return root;
        }
    }
}
