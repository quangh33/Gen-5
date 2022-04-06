package lesson07;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sum-of-left-leaves/
 * @since 2022/04/06 21:12:04
 */
public class TaiVo404SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.sumOfLeftLeaves(treeNode));

        TreeNode treeNode1 = new TreeNode(1);
        System.out.println(solution.sumOfLeftLeaves(treeNode1));
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

    // n: nodes
    // Space Complexity: O(1)
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
