package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_285_InorderSuccessorInBST {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if(root == null)    return root;

        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }

        TreeNode successorNode = null;
        while(root != null) {
            if(root.val > p.val) {
                successorNode = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }

        return successorNode;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNode res = inorderSuccessor(root, root.left.right);
        System.out.println("res: "+res.val);
    }
}
