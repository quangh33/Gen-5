package HomeWorkLesson7;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, true);
    }

    public int dfs(TreeNode root, boolean canRob) {
        if (root == null) return 0;
        int rob = root.val + dfs(root.left, false) + dfs(root.right, false);
        int noRob = dfs(root.left, true) + dfs(root.right, true);
        if (canRob) {
            return Math.max(rob, noRob);
        } else {
            return noRob;
        }
    }
}
