package lesson07;

import utils.TreeGenerator;
import utils.TreeGenerator.TreeNode;

/**
 * @author taivt
 * @link https://leetcode.com/problems/diameter-of-binary-tree/
 * @since 2022/04/06 21:48:01
 */
public class TaiVo543DiameterOfBinaryTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(TreeGenerator.generateBinaryTree(new Integer[]{1, 2, 3, 4, 5})));
        System.out.println(solution.diameterOfBinaryTree(TreeGenerator.generateBinaryTree(new Integer[]{1, 2})));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode node) {
            maxDiameter = 0;
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
