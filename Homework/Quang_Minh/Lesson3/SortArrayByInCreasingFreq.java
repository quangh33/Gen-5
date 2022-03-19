package HomeWorkLesson3;

import javafx.util.Pair;

import java.util.*;

public class SortArrayByInCreasingFreq {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.get(nums[i]) == null) frequencyMap.put(nums[i], 1);
            else {
                int value = frequencyMap.get(nums[i]);
                frequencyMap.put(nums[i], value + 1);
            }
        }
        Pair<Integer, Integer>[] list = new Pair[frequencyMap.size()];
        int index = 0;
        for (int element : frequencyMap.keySet()) {
            Pair<Integer, Integer> temp = new Pair<>(element, frequencyMap.get(element));
            list[index] = temp;
            index++;
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].getValue() > list[j].getValue() || (list[i].getValue() == list[j].getValue() && list[i].getKey() < list[j].getKey())) {
                    Pair<Integer, Integer> temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        index = 0;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].getValue(); j++) {
                result[index] = list[i].getKey();
                index++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {2, 3, 1, 3, 2};
        frequencySort(a);
    }
}
