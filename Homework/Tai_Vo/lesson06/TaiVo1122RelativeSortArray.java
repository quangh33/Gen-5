package lesson06;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/relative-sort-array/
 * @since 2022/03/29 21:34:37
 */
public class TaiVo1122RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
        System.out.println(Arrays.toString(solution.relativeSortArray(new int[]{2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31}, new int[]{2, 42, 38, 0, 43, 21})));
    }

    // n: arr1.length, m: arr2.length
    // Space Complexity: O(n + m)
    // Time Complexity: O(n + m + mLog(m))
    private static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Set<Integer> distinctNums = new HashSet<>(arr2.length);
            for (int number : arr2) {
                distinctNums.add(number);
            }

            Map<Integer, Integer> frequencyNums = new HashMap<>(arr1.length);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int number : arr1) {
                if (distinctNums.contains(number)) {
                    Integer count = frequencyNums.getOrDefault(number, 0);
                    frequencyNums.put(number, count + 1);
                } else {
                    minHeap.add(number);
                }
            }

            int arr1Idx = 0;
            for (int number : arr2) {
                Integer frequency = frequencyNums.get(number);
                Arrays.fill(arr1, arr1Idx, arr1Idx + frequency, number);
                arr1Idx += frequency;
            }
            while (!minHeap.isEmpty()) {
                arr1[arr1Idx] = minHeap.poll();
                arr1Idx++;
            }

            return arr1;
        }

        public int[] relativeSortArray2(int[] arr1, int[] arr2) {
            Map<Integer, Integer> distinctNums = new HashMap<>(arr2.length);
            for (int i = 0; i < arr2.length; i++) {
                distinctNums.put(arr2[i], i);
            }

            return Arrays.stream(arr1).boxed().sorted(Comparator.comparing(number -> {
                if (distinctNums.containsKey(number)) {
                    return distinctNums.get(number);
                }
                return arr2.length + number;
            })).mapToInt(i -> i).toArray();
        }
    }
}
