package lesson07;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sum-of-left-leaves/
 * @since 2022/04/06 21:12:04
 */
public class TaiVo404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.sumOfLeftLeaves(buildBinaryTree(3, 9, 20, null, null, 15, 7)));
        System.out.println(solution.sumOfLeftLeaves(buildBinaryTree(1)));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return dfs(root, false);
        }

        private int dfs(TreeNode node, boolean isLeft) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left == null && right == null) {
                return isLeft ? node.val : 0;
            }

            int rightVal = 0;
            if (right != null) {
                rightVal = dfs(right, false);
            }

            int leftVal = 0;
            if (left != null) {
                leftVal = dfs(left, true);
            }

            return leftVal + rightVal;
        }
    }
}
