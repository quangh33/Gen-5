package Homework.Nam_Nguyen.Lesson9;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_98_ValidateBinarySearchTree {

    static List<Integer> result = new ArrayList<>();

    public static boolean isValidBST(TreeNode root) {
        DFS(root);
        for (int i = 0; i < result.size() - 1; i++) {
            if(result.get(i) >= result.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void DFS(TreeNode node) {
        if(node == null)    return;
        DFS(node.left);
        result.add(node.val);
        DFS(node.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        // root.right.left = new TreeNode(3);
        // root.right.right = new TreeNode(6);
        System.out.println("res: "+isValidBST(root));
    }
}
