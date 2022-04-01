package HomeWorkLesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int element = nums[i];
            if (freq.get(element) != null) {
                int freqOfVal = freq.get(element);
                if (Math.abs(i - freqOfVal) <= k) return true;
                else freq.put(element, i);
            } else {
                freq.put(element, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(a, 1));
    }
}
