package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return DFS(p, q);
    }

    public boolean DFS(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if(p == null && q != null)  return false;
        if(p != null && q == null)  return false;
        if(p.val != q.val)  return false;

        boolean sameLeft = DFS(p.left, q.left);
        boolean sameRight = DFS(p.right, q.right);
        return sameLeft && sameRight;
    } 

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        // p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        // q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        LeetCode_100_SameTree sameTree = new LeetCode_100_SameTree();

        System.out.println("res: "+sameTree.isSameTree(p, q));
    }
    
}
