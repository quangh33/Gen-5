package lesson07;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/most-frequent-subtree-sum/
 * @since 2022/04/11 22:12:46
 */
public class TaiVo508MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3)))));
//        System.out.println(Arrays.toString(solution.findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-5)))));
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
        private final Map<Integer, Integer> treeSumFreq = new HashMap<>();
        private final List<Integer> treeSumArr = new ArrayList<>();
        private int mostFreqTreeSum = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            calculateTreeSum(root);
            return treeSumArr.stream().mapToInt(Integer::intValue).toArray();
        }

        private Integer calculateTreeSum(TreeNode node) {
            if (node == null) {
                return null;
            }

            int treeSum = node.val;
            Integer leftSum = calculateTreeSum(node.left);
            treeSum += leftSum != null ? leftSum : 0;

            Integer rightSum = calculateTreeSum(node.right);
            treeSum += rightSum != null ? rightSum : 0;

            int treeSumReq = treeSumFreq.getOrDefault(treeSum, 0) + 1;
            treeSumFreq.put(treeSum, treeSumReq);

            if (treeSumReq > mostFreqTreeSum) {
                mostFreqTreeSum = treeSumReq;
                treeSumArr.clear();
                treeSumArr.add(treeSum);
            } else if (treeSumReq == mostFreqTreeSum) {
                treeSumArr.add(treeSum);
            }

            return treeSum;
        }
    }
}
