package Homework.Nam_Nguyen.Lesson2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_523_ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
          prefixSum[0] = nums[0];
          for (int i = 1; i < nums.length; i++) {
              prefixSum[i] = nums[i] + prefixSum[i - 1];
          }
           
          Map<Integer, Integer> map = new HashMap<>();
          map.put(0, -1);
           
          for (int i = 0; i < prefixSum.length; i++) {
               
              int res = prefixSum[i];
              if (k != 0) {
                  res = prefixSum[i] % k;
              }
              if (map.containsKey(res) && (i - map.get(res)) > 1) {
                  return true;
              }
               
              if (!map.containsKey(res)) {
                  map.put(res, i);
              }
          }
           
          return false; 
      }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,6};
        int goal = 7;
        System.out.println("res " +checkSubarraySum(nums, goal));
    }
}
