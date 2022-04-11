package Homework.Nam_Nguyen.Lesson7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_107_BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                currentLevel.add(top.val);
                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
                if(i == size - 1) {
                    
                }
            }
            res.add(currentLevel);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        // root.right.left = new TreeNode(5);
        // root.right.left.left = new TreeNode(7);
        // root.right.right = new TreeNode(6);
        System.out.println(levelOrderBottom(root));
    }
}