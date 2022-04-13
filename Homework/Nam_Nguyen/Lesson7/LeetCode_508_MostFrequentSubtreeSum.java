package Homework.Nam_Nguyen.Lesson7;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_508_MostFrequentSubtreeSum {

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

        int maxLength = 0;

        int max(int a, int b) {
            if(a > b)
                return a;
            return b;
        }

        Map<Integer, Integer> sumFrequencies = new HashMap<>();
        int mostFrequencies = 1;
        int numberOfNode = 0;
        int sizeOfOutputArray = 0; // count how many the frequencies that equal to most frequency

        public int DFS(TreeNode node) {
            if(node == null)    return 0;
            int sumLeft = DFS(node.left);
            int sumRight = DFS(node.right);
            int total = node.val + sumLeft + sumRight;
            int frequency = sumFrequencies.getOrDefault(total, 0) + 1;
            numberOfNode++;
            sumFrequencies.put(total, frequency);
            if(frequency > mostFrequencies) {
                sizeOfOutputArray=1;
                mostFrequencies = frequency;
            }else if(frequency == mostFrequencies) {
                sizeOfOutputArray++;
            }
            return total;
            
        }

        public int[] findFrequentTreeSum(TreeNode root) {
            DFS(root);
            int[] result = new int[sizeOfOutputArray];
            int index = 0;
            
            for(Map.Entry<Integer, Integer> entry : sumFrequencies.entrySet()) {
                if(entry.getValue() == mostFrequencies) {
                    result[index++] = entry.getKey();
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode main = new TreeNode();
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(-3);
        TreeNode n11 = new TreeNode(5, n21, n22);
        // TreeNode n12 = new TreeNode(3);
        // TreeNode root = new TreeNode(1, n11, n12);
        System.out.println(main.findFrequentTreeSum(n11));
    }

}
