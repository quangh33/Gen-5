namespace LeetCodeSolutions
{
    public class InOrderSuccessorBST
    {
        private TreeNode successor = null;
        public TreeNode InorderSuccessor(TreeNode root, TreeNode p)
        {
            while (root != null)
            {

                if (p.val >= root.val)
                {
                    root = root.right;
                }
                else
                {
                    successor = root;
                    root = root.left;
                }
            }

            return successor;
        }
    }
}
