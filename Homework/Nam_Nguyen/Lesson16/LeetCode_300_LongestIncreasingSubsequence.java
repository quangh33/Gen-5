package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_300_LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;

        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
        }
        for (int num : f) {
            res = Math.max(num, res);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_300_LongestIncreasingSubsequence prob = new LeetCode_300_LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        prob.lengthOfLIS(nums);
    }
}
