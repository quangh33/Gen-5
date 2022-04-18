package lesson07;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @since 2022/04/06 23:09:11
 */
public class TaiVo94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(buildBinaryTree(1, null, 2, 3)));
        System.out.println(solution.inorderTraversal(buildBinaryTree()));
        System.out.println(solution.inorderTraversal(buildBinaryTree(1)));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private List<Integer> elements;

        public List<Integer> inorderTraversal(TreeNode root) {
            elements = new ArrayList<>();
            inorderTraversalRecursive(root);
            return elements;
        }

        private void inorderTraversalRecursive(TreeNode node) {
            if (node == null) {
                return;
            }

            inorderTraversalRecursive(node.left);
            elements.add(node.val);
            inorderTraversalRecursive(node.right);
        }
    }
}
