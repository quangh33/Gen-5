package HomeWorkLesson7;

public class SumOfLeftLeaves {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.right == null && root.left.left == null) {
            sum += root.left.val;
        }
        dfs(root.left);
        dfs(root.right);
        return sum;
    }
}
