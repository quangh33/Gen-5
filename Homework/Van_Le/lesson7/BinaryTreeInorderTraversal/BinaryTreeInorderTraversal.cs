namespace LeetCodeSolutions
{
    public class BinaryTreeInorderTraversal
    {
        public IList<int> InorderTraversal(TreeNode root)
        {
            List<int> res = new List<int>();
            TreeNode curr = root;
            TreeNode pre;
            while (curr != null)
            {
                if (curr.left == null)
                {
                    res.Add(curr.val);
                    curr = curr.right;
                }
                else
                {
                    pre = curr.left;
                    while (pre.right != null)
                    { 
                        pre = pre.right;
                    }
                    pre.right = curr;
                    TreeNode temp = curr;
                    curr = curr.left;
                    temp.left = null;
                }
            }
            return res;
        }
    }
}
