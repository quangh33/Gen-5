package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_669_TrimBinarySearchTree {

    public static TreeNode trimBST(TreeNode root, int low, int high) {

        if(root == null)    return root;
        if(root.val < low) {
            return trimBST(root.right, low, high);
        }
        if(root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
    
    public static void main(String[] args) {
        int low = 1, high = 3;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        TreeNode res = trimBST(root, low, high);
    }
}
