package HomeWorkLesson3;

import javafx.util.Pair;

import java.util.*;

public class SortArrayByInCreasingFreq {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.get(nums[i]) == null) frequencyMap.put(nums[i], 1);
            else {
                int value = frequencyMap.get(nums[i]);
                frequencyMap.put(nums[i], value + 1);
            }
        }
        List<Integer> listKeys = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(listKeys, (a, b) -> {
            return (frequencyMap.get(a) == frequencyMap.get(b))? b - a : frequencyMap.get(a) - frequencyMap.get(b);
        });

        int[] result = new int[nums.length];
        int i = 0;
        for (int num : listKeys) {
            for (int j = 0; j < frequencyMap.get(num); j++) {
                result[i++] = num;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 1, 3, 2};
        frequencySort(a);
    }
}
