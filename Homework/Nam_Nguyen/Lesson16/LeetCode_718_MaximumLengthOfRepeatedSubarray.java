package Homework.Nam_Nguyen.Lesson16;

public class LeetCode_718_MaximumLengthOfRepeatedSubarray {
    
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int f[][] = new int[n1+1][n2+1];
        int max = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    f[i][j] = f[i-1][j-1] + 1;
                } else {
                    f[i][j] = 0;
                }
                max = Math.max(max, f[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode_718_MaximumLengthOfRepeatedSubarray prob = new LeetCode_718_MaximumLengthOfRepeatedSubarray();
        int[] nums1 = {0,0,0,0,1}, nums2 = {1,0,0,0,0};
        System.out.println("res: "+prob.findLength(nums1, nums2));
    }
}
