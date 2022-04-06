package lesson07;

/**
 * @author taivt
 * @link https://leetcode.com/problems/diameter-of-binary-tree/
 * @since 2022/04/06 21:48:01
 */
public class TaiVo543DiameterOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(treeNode));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode node) {
            calculateDiameter(node);
            return maxDiameter;
        }

        private int calculateDiameter(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int maxHeightLeft = calculateDiameter(node.left);
            int maxHeightRight = calculateDiameter(node.right);
            maxDiameter = Math.max(maxDiameter, maxHeightLeft + maxHeightRight);
            return Math.max(maxHeightLeft, maxHeightRight) + 1;
        }
    }
}
