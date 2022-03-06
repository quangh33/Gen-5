package Homework.Nam_Nguyen.Warmup;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> occ = new HashMap<>();
        int length = nums.length;
        int mid = length/2;
        for (int i = 0; i < mid; i++) {
            if(occ.get(nums[i]) == null){
                occ.put(nums[i], 1);
            }else return true;

            if(occ.get(nums[length - i - 1]) == null){
                occ.put(nums[length - i - 1], 1);
            }else return true;
        }

        if(mid * 2 < length){
            return occ.get(nums[mid]) != null;
        }

        return false;
        
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean res = containsDuplicate(nums);
    }
}