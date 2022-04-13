package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] sumArray = new int[nums.length];
        sumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumArray[i] = sumArray[i-1] + nums[i];
        }
        int minSofar = 0;
        int maxSofar = sumArray[0];
        for (int i = 0; i < sumArray.length; i++) {
            maxSofar = max(maxSofar, sumArray[i] - minSofar);
            minSofar = min(minSofar, sumArray[i]);
        }
        return maxSofar;
    }
    
    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,6,3,3,4};
    }
}
