package Homework.Nam_Nguyen.Lesson7;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_BinaryTreeProOrderTraversal {

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

        List<Integer> result;

        public void DFS(TreeNode node) {
            if(node == null)    return;
            result.add(node.val);
            DFS(node.left);
            DFS(node.right);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            result = new ArrayList<>();
            DFS(root);
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);
        TreeNode n11 = new TreeNode(2, n21, n22);
        TreeNode n12 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n11, n12);
        System.out.println(main.preorderTraversal(root));
    }

}
