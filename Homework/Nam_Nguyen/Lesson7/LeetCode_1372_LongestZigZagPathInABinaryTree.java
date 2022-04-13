package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_1372_LongestZigZagPathInABinaryTree {

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

        public void DFS(TreeNode node, boolean isLeftDirection, int depth) {
            longestPath = max(depth, longestPath);
            if(node == null)    return;

            if(isLeftDirection) {
                DFS(node.left, true, 0);
                DFS(node.right, false, depth + 1);
            }else {
                DFS(node.left, true, depth + 1);
                DFS(node.right, false, 0);
            }
        }

        public int longestUnivaluePath(TreeNode root) {
            DFS(root.left, true,  0);
            DFS(root.right, false,  0);
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
