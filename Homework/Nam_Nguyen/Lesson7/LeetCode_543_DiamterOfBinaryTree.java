package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_543_DiamterOfBinaryTree {

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

        int maxLength = 0;

        int max(int a, int b) {
            if(a > b)
                return a;
            return b;
        }

        public int DFS(TreeNode node) {
            if(node == null)    return 0;
            int lengthLeft = DFS(node.left);
            int lengthRight = DFS(node.right);
            int totalLength = lengthLeft + lengthRight;
            maxLength = max(totalLength, maxLength);
            return max(lengthLeft, lengthRight) + 1;
            
        }

        public int diameterOfBinaryTree(TreeNode root) {
            DFS(root);
            return maxLength;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);
        TreeNode n11 = new TreeNode(2, n21, n22);
        TreeNode n12 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n11, n12);
        System.out.println(main.diameterOfBinaryTree(root));
    }

}
