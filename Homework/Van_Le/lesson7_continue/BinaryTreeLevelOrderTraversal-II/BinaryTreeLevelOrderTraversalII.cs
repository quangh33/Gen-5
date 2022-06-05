namespace LeetCodeSolutions
{
    public class BinaryTreeLevelOrderTraversalII
    {
        public IList<IList<int>> LevelOrderBottom(TreeNode root)
        {
            List<List<int>> res = new List<List<int>>();
            if (root == null) return res.ToArray();
            Queue<TreeNode> queue = new Queue<TreeNode>();
            queue.Enqueue(root);

            while (queue.Count > 0)
            {
                int size = queue.Count;
                List<int> listItem = new List<int>();
                for (int i = 0; i < size; i++)
                {
                    TreeNode node = queue.Dequeue();
                    listItem.Add(node.val);
                    if(i == size - 1) res.Add(listItem);
                    if (node.left != null) queue.Enqueue(node.left);
                    if (node.right != null) queue.Enqueue(node.right);
                }
            }
            res.Reverse();

            return res.ToArray();
        }
    }
}
