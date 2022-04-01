package Homework.Nam_Nguyen.Lesson5;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_454_4SumII {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> mapFrequencyArray12 = new HashMap<>();
        Map<Integer, Integer> mapFrequencyArray34 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                mapFrequencyArray12.put(nums1[i] + nums2[j], mapFrequencyArray12.getOrDefault(nums1[i] + nums2[j], 0)+1);
                mapFrequencyArray34.put(nums3[i] + nums4[j], mapFrequencyArray34.getOrDefault(nums3[i] + nums4[j], 0)+1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: mapFrequencyArray12.entrySet()){
            if(mapFrequencyArray34.get(0 - entry.getKey()) != null){
                result+=entry.getValue() * mapFrequencyArray34.get(0 - entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        int result = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("res "+result);
    }
    
}
