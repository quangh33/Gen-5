package HomeWorkLesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 3) return 0;
        int res = 0;
        for (int i = 0; i < length - 2; i++) {
            int remain = target - nums[i];
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < remain) {
                    System.out.println(left + " " + right);
                    res = res + (right - left);
                    left++;
                } else right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-2,0,1,3};
        threeSumSmaller(a, 2);
    }
}
