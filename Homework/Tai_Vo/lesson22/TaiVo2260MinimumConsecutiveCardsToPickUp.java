package lesson22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taivt
 * @since 2022/06/07 21:01:19
 */
public class TaiVo2260MinimumConsecutiveCardsToPickUp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));
        System.out.println(solution.minimumCardPickup(new int[]{1, 0, 5, 3}));
    }

    private static class Solution {
        public int minimumCardPickup(int[] cards) {
            Map<Integer, Integer> lastIdxMap = new HashMap<>();

            int minLength = Integer.MAX_VALUE;
            for (int i = 0; i < cards.length; i++) {
                Integer lastIdx = lastIdxMap.get(cards[i]);
                if (lastIdx != null) {
                    minLength = Math.min(minLength, i - lastIdx + 1);
                }
                lastIdxMap.put(cards[i], i);
            }

            return minLength != Integer.MAX_VALUE ? minLength : -1;
        }
    }
}
