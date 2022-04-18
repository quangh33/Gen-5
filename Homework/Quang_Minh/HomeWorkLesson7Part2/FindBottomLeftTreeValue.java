package HomeWorkLesson7Part2;

import HomeWorkLesson7.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int leftValue = 0;
        while (true) {
            if (queue.size() == 0) break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == 0 && currentNode.left == null && currentNode.right == null) leftValue = currentNode.val;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }

        }
        return leftValue;
    }
}
