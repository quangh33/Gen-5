package Homework.Nam_Nguyen.Lesson2;

import java.util.HashMap;

public class LeetCode_930_BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int numbersOfSubrrays = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i+1];
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        int current;

        for (int i = 0; i < prefixSum.length; i++) {
            current = count.getOrDefault(prefixSum[i], 0);
            numbersOfSubrrays+=current;
            count.put(prefixSum[i] + goal, count.getOrDefault(prefixSum[i] + goal, 0)+1);
        }

        return numbersOfSubrrays; 
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println("res " +numSubarraysWithSum(nums, goal));
    }
}
