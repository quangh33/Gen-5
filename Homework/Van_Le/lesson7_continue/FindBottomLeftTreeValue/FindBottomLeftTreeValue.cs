namespace LeetCodeSolutions
{
    public class FindBottomLeftTreeValue
    {
        public int FindBottomLeftValue(TreeNode root)
        {
            if(root == null) return -1;

            Queue<TreeNode> queue = new Queue<TreeNode>();
            queue.Enqueue(root);
            int ans = -1;

            while(queue.Count > 0)
            {
                int size = queue.Count;
                for(int i = 0; i < size; i++)
                {
                    TreeNode node = queue.Dequeue();

                    if (i == size - 1) ans = node.val;

                    if (node.right != null) queue.Enqueue(node.right);
                    if (node.left != null) queue.Enqueue(node.left);
                }
            }

            return ans;
        }
    }
}
