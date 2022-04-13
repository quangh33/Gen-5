package Homework.Nam_Nguyen.Lesson5;

import java.util.HashMap;

class SubarrayDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        int numbersOfSubrrays = 0;
        int sum = 0;
        HashMap<Integer, Integer> moduleMap = new HashMap<>();
        moduleMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int module = (sum%k+k) % k;
            int temp = moduleMap.get(module) == null ? 0 : moduleMap.get(module);
            numbersOfSubrrays+=temp;
            moduleMap.put(module, temp+1);
        }
        return numbersOfSubrrays;
    }

    public static void main(String[] args) {
        int nums[] = {-1,-9,-4,0};
        System.out.println("res "+subarraysDivByK(nums, 9));
    }
}