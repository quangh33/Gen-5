package HomeWorkLastAlgoLesson;

public class MaxLengthOfRepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        if (nums1.length < 1 || nums2.length < 1) {
            return 0;
        }
        int[][] state = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    state[i][j] = 1 + state[i - 1][j - 1];
                } else {
                    state[i][j] = 0;
                }
                max = Math.max(state[i][j], max);
            }
        }
        return max;
    }
}
