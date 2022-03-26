package Homework.Nam_Nguyen.Lesson2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_1636_SortArrayByIncreasingFrequency {

    static Map<Integer, Integer> frequencyMap = new HashMap<>();

    public static int[] frequencySort(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // to use built-in sort with custom comparator, I need to pass an list of object,
        // so I map the array of int (primative) to list of Integer
        // here I need extra space O(n), n = length of nums
        // but n in range [1, 100], it doesn't matter.
        for(int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
            result.add(num);
        }
        Collections.sort(result, new Comparator<Integer>() {
            public int compare(Integer number1, Integer number2) {
                if(frequencyMap.get(number2) == frequencyMap.get(number1)){
                    return number2 - number1;
                }
                return frequencyMap.get(number1) - frequencyMap.get(number2);
            }
        });
        // I map our result to array of int to meet the problem's output
        return result.stream().mapToInt(i -> i).toArray();
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
