package HomeWorkLesson4;

import java.util.HashMap;

public class SubArraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int size = nums.length;
        int[] prefixSum = new int[size];
        prefixSum[0] = nums[0];
        int result = 0;
        for (int i = 1; i < size; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> freqOfSurplus = new HashMap<>();
        for (int prefix : prefixSum) {
            int sur = prefix % k;
            if (sur < 0) sur += k;
            if (sur == 0) result++;
            if (freqOfSurplus.get(sur) != null) {
                result += freqOfSurplus.get(sur);
                int freq = freqOfSurplus.get(sur);
                freq++;
                freqOfSurplus.put(sur, freq);
            } else {
                freqOfSurplus.put(sur, 1);
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(a,k));
    }
}
