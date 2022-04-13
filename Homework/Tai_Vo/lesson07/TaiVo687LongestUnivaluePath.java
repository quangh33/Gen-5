package lesson07;

import utils.TreeGenerator;
import utils.TreeGenerator.TreeNode;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-univalue-path/
 * @since 2022/04/13 20:45:43
 */
public class TaiVo687LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(TreeGenerator.generateBinaryTree(new Integer[]{5, 4, 5, 1, 1, null, 5})));
        System.out.println(solution.longestUnivaluePath(TreeGenerator.generateBinaryTree(new Integer[]{1, 4, 5, 4, 4, null, 5})));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private int longestLength = 0;

        public int longestUnivaluePath(TreeNode root) {
            longestLength = 0;
            calculateUnivalueLength(root);
            return longestLength;
        }

        private int calculateUnivalueLength(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = calculateUnivalueLength(node.left);
            int right = calculateUnivalueLength(node.right);

            int arrowLeft = 0, arrowRight = 0;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft = left + 1;
            }

            if (node.right != null && node.right.val == node.val) {
                arrowRight = right + 1;
            }

            longestLength = Math.max(arrowLeft + arrowRight, longestLength);
            return Math.max(arrowLeft, arrowRight);
        }
    }
}
