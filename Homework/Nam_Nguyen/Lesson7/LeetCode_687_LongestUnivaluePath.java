package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_687_LongestUnivaluePath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        int longestPath = 0;

        int max(int a, int b) {
            if(a > b)
                return a;
            return b;
        }

        public int DFS(TreeNode node, int value) {
            if(node == null)    return 0;
            int path = 0;

            int left = DFS(node.left, node.val);
            int right = DFS(node.right, node.val);
            int totalPath = left + right;
            longestPath = max(totalPath, longestPath);
            if(node.val == value)  path = max(left, right) + 1;
            return path;
        }

        public int longestUnivaluePath(TreeNode root) {
            if(root != null)
                DFS(root, root.val);
            return longestPath;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode ll1 = new TreeNode(1);
        TreeNode lr1 = new TreeNode(1);
        TreeNode l0 = new TreeNode(4, ll1, lr1);
        TreeNode rl1 = new TreeNode(1);
        TreeNode rr1 = new TreeNode(1);
        TreeNode r0 = new TreeNode(1, null, rr1);
        TreeNode root = new TreeNode(1, l0, r0);
        System.out.println(main.longestUnivaluePath(root));
    }

}
