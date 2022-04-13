package HomeWorkLesson4;

import java.util.HashMap;
import java.util.Set;

public class FourSumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int size = nums1.length;
        int res = 0;
        HashMap<Integer, Integer> freqSums12 = new HashMap<>();
        HashMap<Integer, Integer> freqSums34 = new HashMap<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sums12 = nums1[i] + nums2[j];
                int sums34 = nums3[i] + nums4[j];
                if (freqSums12.get(sums12) != null) {
                    int freq12 = freqSums12.get(sums12);
                    freq12++;
                    freqSums12.put(sums12, freq12);
                } else {
                    freqSums12.put(sums12, 1);
                }
                if (freqSums34.get(sums34) != null) {
                    int freq34 = freqSums34.get(sums34);
                    freq34++;
                    freqSums34.put(sums34, freq34);
                } else {
                    freqSums34.put(sums34, 1);
                }
            }
        }
        Set<Integer> setOfSum12 = freqSums12.keySet();
        for (int sum12 : setOfSum12) {
            int sum34Target = 0 - sum12;
            if (freqSums34.get(sum34Target) != null) {
                res += freqSums12.get(sum12) * freqSums34.get(sum34Target);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {-2,-1};
        int[]c = {-1,2};
        int[]d = {0,2};
        System.out.println(fourSumCount(a,b,c,d));
    }
}
