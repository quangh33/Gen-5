package Homework.Nam_Nguyen.Lesson7;

public class LeetCode_404_SumOfLeftLeaves {

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

        int sum = 0;

        public void DFS(TreeNode node) {
            if(node == null)    return;
            if(node.left != null) {
                if(node.left.left == null  && node.left.right == null)
                    sum+=node.left.val;
                DFS(node.left);
            }
            DFS(node.right);
        }

        public int sumOfLeftLeaves(TreeNode root) {
            DFS(root);
            return sum;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);
        TreeNode n11 = new TreeNode(2, n21, n22);
        TreeNode n12 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n11, n12);
        main.sumOfLeftLeaves(root);
    }

}
