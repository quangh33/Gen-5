package lesson09;

import utils.TreeBuilder;
import utils.TreeNode;

/**
 * @author taivt
 * @link https://leetcode.com/problems/validate-binary-search-tree/
 * @since 2022/04/17 21:17:14
 */
public class TaiVo98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution1 = new Solution();
        System.out.println(solution1.isValidBST(TreeBuilder.buildBinaryTree(2, 1, 3)));
        System.out.println(solution1.isValidBST(TreeBuilder.buildBinaryTree(5, 1, 4, null, null, 3, 6)));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isValidBST(TreeBuilder.buildBinaryTree(2, 1, 3)));
        System.out.println(solution2.isValidBST(TreeBuilder.buildBinaryTree(5, 1, 4, null, null, 3, 6)));
        System.out.println(solution2.isValidBST(TreeBuilder.buildBinaryTree(2147483647)));
        System.out.println(solution2.isValidBST(TreeBuilder.buildBinaryTree(2147483647, 2147483647)));
        System.out.println(solution2.isValidBST(TreeBuilder.buildBinaryTree(-2147483648, -2147483648)));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private Integer prev;
        private boolean isValid;

        public boolean isValidBST(TreeNode root) {
            isValid = true;
            check(root);
            return isValid;
        }

        private void check(TreeNode node) {
            if (node == null) {
                return;
            }

            check(node.left);
            if (prev != null && prev >= node.val) {
                isValid = false;
                return;
            } else {
                prev = node.val;
            }
            check(node.right);
        }
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution2 {

        public boolean isValidBST(TreeNode root) {
            return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean check(TreeNode node, long min, long max) {
            if (node == null) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }

            return check(node.left, min, node.val) && check(node.right, node.val, max);
        }
    }
}
