package lesson07;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-univalue-path/
 * @since 2022/04/13 20:45:43
 */
public class TaiVo687LongestUnivaluePath {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(4, new TreeNode(1), new TreeNode(1));
//        TreeNode right = new TreeNode(5, null, new TreeNode(5));
//        System.out.println(new Solution().longestUnivaluePath(new TreeNode(5, left, right)));
//
//        TreeNode left = new TreeNode(4, new TreeNode(4), new TreeNode(4));
//        TreeNode right = new TreeNode(5, null, new TreeNode(5));
//        System.out.println(new Solution().longestUnivaluePath(new TreeNode(1, left, right)));

        TreeNode left = new TreeNode(1, new TreeNode(1), new TreeNode(1));
        TreeNode right = new TreeNode(1, new TreeNode(1), null);
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(1, left, right));
        System.out.println(new Solution().longestUnivaluePath(treeNode));
    }

    private static class TreeNode {
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
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private int longestLength = 0;

        public int longestUnivaluePath(TreeNode root) {
            calPathLength(root);
            return longestLength;
        }

        private int calPathLength(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = calPathLength(node.left);
            int right = calPathLength(node.right);

            int arrowLeft = 0, arrowRight = 0;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft = left + 1;
            }

            if (node.right != null && node.right.val == node.val) {
                arrowRight = right + 1;
            }

            longestLength = Math.max(arrowLeft + arrowRight, longestLength);
            return Math.max(arrowLeft, arrowRight);
        }
    }
}
