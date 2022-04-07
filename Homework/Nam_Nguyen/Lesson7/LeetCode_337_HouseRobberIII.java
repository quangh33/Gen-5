package Homework.Nam_Nguyen.Lesson7;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_337_HouseRobberIII {

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

        Map<TreeNode, Integer> amountMap;

        int max(int a, int b) {
            if (a > b)
                return a;
            return b;
        }

        public int DFS(TreeNode root) {
            if (root == null) return 0;
            if (amountMap.containsKey(root)) return amountMap.get(root);
    
            int amount = root.val;
            if (root.left != null) {
                amount += DFS(root.left.left) + DFS(root.left.right);
            }
            if (root.right != null) {
                amount += DFS(root.right.left) + DFS(root.right.right);
            }
            
            amount = max(amount, DFS(root.left) + DFS(root.right));
            amountMap.put(root, amount);
    
            return amount;
        }

        public int rob(TreeNode root) {
            amountMap = new HashMap<>();
            int res = DFS(root);
            System.out.println("res: " + res);
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode ll1 = new TreeNode(1);
        TreeNode lr1 = new TreeNode(3);
        TreeNode l0 = new TreeNode(4, ll1, lr1);
        TreeNode rl1 = new TreeNode(1);
        TreeNode rr1 = new TreeNode(1);
        TreeNode r0 = new TreeNode(5, null, rr1);
        TreeNode root = new TreeNode(3, l0, r0);
        System.out.println(main.rob(root));
    }

}
