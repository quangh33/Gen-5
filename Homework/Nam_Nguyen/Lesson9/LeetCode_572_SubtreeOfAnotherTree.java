package Homework.Nam_Nguyen.Lesson9;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_572_SubtreeOfAnotherTree {
    
    Queue<TreeNode> queue = new LinkedList<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(isSameTree(node, subRoot)) return true;
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

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
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(2);

        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        LeetCode_572_SubtreeOfAnotherTree subtree = new LeetCode_572_SubtreeOfAnotherTree();

        System.out.println("res: "+subtree.isSubtree(p, q));
    }
    
}
