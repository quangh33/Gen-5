package HomeWorkLesson7;

public class LongestZigZagPath {
    int result = 0;

    public int longestZigZag(TreeNode root) {
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        result = Math.max(result, Math.max(left, right));
        return result;
    }

    public int dfs(TreeNode root, boolean isLeft) {
        if (root == null)
            return 0;
        int left = dfs(root.left, true);
        int right = dfs(root.right, false);
        result = isLeft ? Math.max(result, left) : Math.max(result, right);
        return isLeft ? right + 1 : left + 1;
    }
}
