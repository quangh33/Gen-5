package HomeWorkLesson7Part2;

import HomeWorkLesson7.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    Map<Integer, List<Integer>> resultAsMapReverse = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        for (int key : resultAsMapReverse.keySet()) {
            result.add(0, resultAsMapReverse.get(key));
        }
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) return;
        List<Integer> currentNodes = resultAsMapReverse.get(level);
        if (currentNodes == null) currentNodes = new ArrayList<>();
        currentNodes.add(root.val);
        resultAsMapReverse.put(level, currentNodes);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
