package lesson03;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * @since 2022/03/24 20:31:03
 */
public class TaiVo1636SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(nlog(n))
    private static class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : nums) {
                Integer frequency = frequencyMap.getOrDefault(num, 0);
                frequencyMap.put(num, frequency + 1);
            }

            Comparator<FrequencyNumber> comparator = Comparator.comparing(o -> o.frequency);
            comparator = comparator.thenComparing(o -> -o.value);
            PriorityQueue<FrequencyNumber> priorityQueue = new PriorityQueue<>(comparator);
            frequencyMap.forEach((value, frequency) -> priorityQueue.add(new FrequencyNumber(value, frequency)));

            int[] result = new int[nums.length];
            int count = 0;
            while (!priorityQueue.isEmpty()) {
                FrequencyNumber frequencyNumber = priorityQueue.poll();
                Arrays.fill(result, count, count + frequencyNumber.frequency, frequencyNumber.value);
                count += frequencyNumber.frequency;
            }
            return result;
        }

        private static class FrequencyNumber {
            int value;
            int frequency;

            public FrequencyNumber(int value, int frequency) {
                this.value = value;
                this.frequency = frequency;
            }
        }
    }
}
