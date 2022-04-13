package lesson07;

import utils.TreeGenerator;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taivt
 * @link https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @since 2022/04/06 22:38:11
 */
public class TaiVo144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preorderTraversal(TreeGenerator.generateBinaryTree(new Integer[]{1, null, 2, 3})));
        System.out.println(solution.preorderTraversal(TreeGenerator.generateBinaryTree(new Integer[]{})));
        System.out.println(solution.preorderTraversal(TreeGenerator.generateBinaryTree(new Integer[]{1})));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private List<Integer> elements;

        public List<Integer> preorderTraversal(TreeNode root) {
            elements = new ArrayList<>();
            preorderTraversalRecursive(root);
            return elements;
        }

        private void preorderTraversalRecursive(TreeNode node) {
            if (node == null) {
                return;
            }

            elements.add(node.val);
            preorderTraversalRecursive(node.left);
            preorderTraversalRecursive(node.right);
        }
    }
}
