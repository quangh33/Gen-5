package lesson07;

import utils.TreeNode;

import java.util.*;

import static utils.TreeBuilder.buildBinaryTree;

/**
 * @author taivt
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @since 2022/04/15 00:34:57
 */
public class TaiVo107BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(buildBinaryTree(3, 9, 20, null, null, 15, 7)));
        System.out.println(solution.levelOrderBottom(buildBinaryTree(1)));
        System.out.println(solution.levelOrderBottom(buildBinaryTree()));
    }

    private static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return List.of();
            }

            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                List<Integer> curNodesValues = new ArrayList<>();
                List<TreeNode> nextNodes = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    curNodesValues.add(node.val);
                    if (node.left != null) {
                        nextNodes.add(node.left);
                    }
                    if (node.right != null) {
                        nextNodes.add(node.right);
                    }
                }
                result.add(curNodesValues);
                queue.addAll(nextNodes);
            }

            Collections.reverse(result);
            return result;
        }
    }
}
