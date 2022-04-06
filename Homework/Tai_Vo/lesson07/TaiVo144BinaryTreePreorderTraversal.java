package lesson07;

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
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(solution.preorderTraversal(treeNode));
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

    private static class Solution {
        private final List<Integer> preorderElements = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return preorderElements;
            }

            preorderElements.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

            return preorderElements;
        }
    }
}
