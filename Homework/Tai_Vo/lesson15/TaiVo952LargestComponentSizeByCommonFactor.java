package lesson15;

import java.util.*;

/**
 * @author taivt
 * @link https://leetcode.com/problems/largest-component-size-by-common-factor/
 * @since 2022/05/21 22:16:30
 */
public class TaiVo952LargestComponentSizeByCommonFactor {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println(solution.largestComponentSize(new int[]{20, 50, 9, 63}));
        System.out.println(solution.largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }

    // n: nums.length, m: max(nums[i...n])
    // Space Complexity: O(n + log(m))  ???
    // Time Complexity: O(n * log2(m) * log(m)) ???
    private static class Solution {

        private static class DisjointSet {
            private final Map<Integer, Integer> parent = new HashMap<>();

            public int find(int x) {
                Integer rootX = parent.getOrDefault(x, x);
                if (x == rootX) {
                    return x;
                }
                rootX = find(rootX);
                parent.put(x, rootX);
                return rootX;
            }

            public boolean union(int u, int v) {
                int rootU = find(u);
                int rootV = find(v);
                if (rootU == rootV) {
                    return false;
                } else {
                    parent.put(rootU, rootV);
                    return true;
                }
            }
        }

        public int largestComponentSize(int[] nums) {
            DisjointSet disjointSet = new DisjointSet();
            for (int num : nums) {
                Set<Integer> primeFactors = findPrimeFactors(num);
                for (Integer primeFactor : primeFactors) {
                    disjointSet.union(num, primeFactor);
                }
            }

            int maxGroupCount = 0;
            Map<Integer, Integer> groupCount = new HashMap<>();
            for (int num : nums) {
                int rootNum = disjointSet.find(num);
                int count = groupCount.getOrDefault(rootNum, 0) + 1;
                groupCount.put(rootNum, count);
                maxGroupCount = Math.max(maxGroupCount, count);
            }

            return maxGroupCount;
        }

        private Set<Integer> findPrimeFactors(int num) {
            Set<Integer> primeFactors = new HashSet<>();
            int factor = 2;
            while (num >= factor * factor) {
                if (num % factor == 0) {
                    primeFactors.add(factor);
                    num = num / factor;
                } else {
                    factor += 1;
                }
            }
            primeFactors.add(num);
            return primeFactors;
        }

    }
}
