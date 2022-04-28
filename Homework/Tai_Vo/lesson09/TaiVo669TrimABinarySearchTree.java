package lesson09;

import utils.TreeNode;

import static utils.TreeBuilder.buildBinaryTree;
import static utils.TreeBuilder.toArray;

/**
 * @author taivt
 * @link https://leetcode.com/problems/trim-a-binary-search-tree/
 * @since 2022/04/25 18:34:23
 */
public class TaiVo669TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode newTree1 = solution.trimBST(buildBinaryTree(1, 0, 2), 1, 2);
        System.out.println(toArray(newTree1));
        TreeNode newTree2 = solution.trimBST(buildBinaryTree(3, 0, 4, null, 2, null, null, 1), 4, 4);
        System.out.println(toArray(newTree2));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            if (root.val < low) {
                return trimBST(root.right, low, high);
            }

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
