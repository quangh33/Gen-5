package HomeWorkLesson7;

public class LongestUnivaluePath {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return max;
    }

    int dfs(TreeNode root, int prevValue) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left, root.val);
        int rightVal = dfs(root.right, root.val);
        max = Math.max(max, leftVal + rightVal);
        return root.val != prevValue ? 0 : 1 + Math.max(leftVal, rightVal);
    }
}
