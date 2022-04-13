package utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taivt
 * @since 2022/04/13 23:20:02
 */
public class TreeGenerator {

    public static TreeNode generateBinaryTree(Integer[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNode = 1;
        while (!queue.isEmpty() && curNode < nodes.length) {
            TreeNode node = queue.poll();
            Integer leftVal = nodes[curNode++];
            if (leftVal != null) {
                TreeNode left = new TreeNode(leftVal);
                node.left = left;
                queue.add(left);
            }
            if (curNode >= nodes.length) {
                break;
            }
            Integer rightVal = nodes[curNode++];
            if (rightVal != null) {
                TreeNode right = new TreeNode(rightVal);
                node.right = right;
                queue.add(right);
            }
        }

        return root;
    }
}
