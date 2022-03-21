package Homework.Nam_Nguyen.Lesson2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1636_SortArrayByIncreasingFrequency {

    static Map<Integer, Integer> frequencyMap = new HashMap<>();

    public static int[] frequencySort(int[] nums) {
        for(int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if(frequencyMap.get(nums[i]) > frequencyMap.get(nums[j])) {
                    swap(i, j, nums);
                }else if(frequencyMap.get(nums[i]) == frequencyMap.get(nums[j])){
                    if(nums[i] < nums[j]) {
                        swap(i, j, nums);
                    }
                }
            }
        }
        return nums;
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};
        frequencySort(nums); 
    }
    
}
