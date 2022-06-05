package utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taivt
 * @since 2022/04/13 23:20:02
 */
public class TreeBuilder {

    public static TreeNode buildBinaryTree(Integer... nodes) {
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

    public static List<Integer> toArray(TreeNode node) {
        List<Integer> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> curLevelArray = new ArrayList<>();
            boolean isAllNull = true;
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    curLevelArray.add(null);
                    continue;
                }
                isAllNull = false;
                curLevelArray.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (!isAllNull) {
                array.addAll(curLevelArray);
            }
        }
        return array;
    }
}
