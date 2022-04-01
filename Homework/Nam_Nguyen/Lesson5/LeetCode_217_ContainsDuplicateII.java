package Homework.Nam_Nguyen.Lesson5;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> occurences = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(occurences.get(nums[i]) != null) return true;
            occurences.put(nums[i], 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {10000000,1000000,11};
        boolean res = containsDuplicate(nums);
    }
}