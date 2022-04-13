package lesson07;

import utils.TreeGenerator;
import utils.TreeGenerator.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/most-frequent-subtree-sum/
 * @since 2022/04/11 22:12:46
 */
public class TaiVo508MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(TreeGenerator.generateBinaryTree(new Integer[]{5, 2, -3}))));
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(TreeGenerator.generateBinaryTree(new Integer[]{5, 2, -5}))));
    }

    // n: nodes
    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        private final Map<Integer, Integer> treeSumFreqMap = new HashMap<>();
        private int mostFreqTreeSum = 0;

        public int[] findFrequentTreeSum(TreeNode root) {
            calculateTreeSum(root);
            return treeSumFreqMap.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == mostFreqTreeSum)
                    .map(Map.Entry::getKey)
                    .mapToInt(Integer::intValue)
                    .toArray();
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

            int treeSumReq = treeSumFreqMap.getOrDefault(treeSum, 0) + 1;
            treeSumFreqMap.put(treeSum, treeSumReq);

            if (treeSumReq > mostFreqTreeSum) {
                mostFreqTreeSum = treeSumReq;
            }

            return treeSum;
        }
    }
}
