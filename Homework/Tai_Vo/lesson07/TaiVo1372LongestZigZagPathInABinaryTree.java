package lesson07;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * @since 2022/04/13 20:45:43
 */
public class TaiVo1372LongestZigZagPathInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestZigZag(buildBinaryTree(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1)));
        System.out.println(solution.longestZigZag(buildBinaryTree(1, 1, 1, null, 1, null, null, 1, 1, null, 1)));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private int longestLength = 0;

        public int longestZigZag(TreeNode root) {
            longestLength = 0;
            calculateZigZagLength(root.left, false);
            calculateZigZagLength(root.right, true);
            return longestLength;
        }

        private int calculateZigZagLength(TreeNode node, boolean nextToLeft) {
            if (node == null) {
                return 0;
            }

            int leftLength = calculateZigZagLength(node.left, false) + 1;
            int rightLength = calculateZigZagLength(node.right, true) + 1;

            if (nextToLeft) {
                longestLength = Math.max(leftLength, longestLength);
                return leftLength;
            } else {
                longestLength = Math.max(rightLength, longestLength);
                return rightLength;
            }
        }
    }
}
