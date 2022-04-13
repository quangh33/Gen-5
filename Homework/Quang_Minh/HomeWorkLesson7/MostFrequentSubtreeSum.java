package HomeWorkLesson7;

import java.util.*;

public class MostFrequentSubtreeSum {
    int max = 0;
    private HashMap<Integer, Integer> freqMap = new HashMap();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> result = new ArrayList();
        Set<Integer> keys = freqMap.keySet();
        for (int key : keys) {
            if ((int) freqMap.get(key) == this.max) {
                result.add(key);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int val = root.val + dfs(root.left) + dfs(root.right);
        if (freqMap.get(val) != null) this.freqMap.put(val, freqMap.get(val) + 1);
        else freqMap.put(val, 1);
        this.max = Math.max(this.max, this.freqMap.get(val));
        return val;
    }
}
