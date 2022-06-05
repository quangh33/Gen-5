package HomeWorkLastAlgoLesson;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int [] state = new int[nums.length];
        int max = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            state[i] = 1;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] > nums[i]) {
                    state[i] = Math.max(state[i], 1 + state[j]);
                }
            }
            max = Math.max(state[i], max);
        }
        return max;
    }
}
