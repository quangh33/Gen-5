package lesson07;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/house-robber-iii/
 * @since 2022/04/13 21:50:01
 */
public class TaiVo337HouseRobberIII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(buildBinaryTree(3, 2, 3, null, 3, null, 1)));
        System.out.println(solution.rob(buildBinaryTree(3, 4, 5, 1, 3, null, 1)));
        System.out.println(solution.rob(buildBinaryTree(3, 2, 20, 1, 5, null, 4)));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public int rob(TreeNode root) {
            int[] results = tryRob(root);
            return Math.max(results[0], results[1]);
        }

        private int[] tryRob(TreeNode node) {
            if (node == null) {
                //             rob, not rob
                return new int[]{0, 0};
            }

            int[] left = tryRob(node.left);
            int[] right = tryRob(node.right);

            int robThisNode = node.val + left[1] + right[1];
            int notRobThisNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return new int[]{robThisNode, notRobThisNode};
        }
    }
}
