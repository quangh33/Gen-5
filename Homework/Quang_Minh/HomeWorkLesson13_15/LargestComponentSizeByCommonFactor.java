package HomeWorkLesson13_15;

import java.util.*;

public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        Map<Integer, Integer> numVsPrime = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(max + 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                List<Integer> primeFactors = getPrimeFactors(nums[i]);
                numVsPrime.put(nums[i], primeFactors.get(0));
                for (int j = 1; j < primeFactors.size(); j++) {
                    disjointSet.union(primeFactors.get(j - 1), primeFactors.get(j));
                }
            }
        }
        Map<Integer, Integer> rootVsSize = new HashMap<>();
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                int firstPrime = numVsPrime.get(nums[i]);
                int root = disjointSet.find(firstPrime);
                int size = rootVsSize.getOrDefault(root, 0);
                size++;
                rootVsSize.put(root, size);
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }


    public static List<Integer> getPrimeFactors(int n) {
        HashSet<Integer> prime = new HashSet<>();
        while (n % 2 == 0) {
            prime.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                prime.add(i);
                n /= i;
            }
        }
        if (n > 2) prime.add(n);
        return new ArrayList<>(prime);
    }

    public static void main(String[] args) {
    }
}

