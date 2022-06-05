package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_226_InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if(root == null)    return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        invertTree(root);
    }
}
