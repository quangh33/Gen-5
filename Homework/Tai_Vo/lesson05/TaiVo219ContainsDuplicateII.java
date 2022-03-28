package lesson05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @link https://leetcode.com/problems/contains-duplicate-ii/
 * @since 2022/03/28 22:57:30
 */
public class TaiVo219ContainsDuplicateII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    // Space Complexity: O(n)
    // Time Complexity: O(n)
    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> lastIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                Integer lastIndex = lastIndexMap.get(num);
                if (lastIndex != null && i - lastIndex <= k) {
                    return true;
                }
                lastIndexMap.put(num, i);
            }
            return false;
        }
    }
}
