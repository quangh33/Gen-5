package HomeWorkLesson11;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 4) return null;
        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < length; i++) {
            // 3sums
            for (int j = i + 1; j < length - 1; j++) {
                int remain = target - nums[i] - nums[j];
                int l = j + 1, r = length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == remain) {
                        res.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while (l + 1 < length && nums[l + 1] == nums[l]) l++;
                        while (r - 1 >= 0 && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < remain) l++;
                    else r--;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 2};
        System.out.println(fourSum(a, 8).size());
    }

}
