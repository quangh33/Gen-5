package lesson09;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/inorder-successor-in-bst/
 * @since 2022/04/20 23:26:05
 */
public class TaiVo285InorderSuccessorInBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inorderSuccessor(buildBinaryTree(2, 1, 3), new TreeNode(1)));
        System.out.println(solution.inorderSuccessor(buildBinaryTree(5, 3, 6, 2, 4, null, null, 1), new TreeNode(6)));
        System.out.println(solution.inorderSuccessor(buildBinaryTree(2, null, 3), new TreeNode(2)));
        System.out.println(solution.inorderSuccessor(buildBinaryTree(5, 3, 6, 2, 4, null, null, 1), new TreeNode(1)));
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode successor = null;
            while (root != null) {
                if (root.val > p.val) {
                    successor = root;
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
            return successor;
        }
    }
}
