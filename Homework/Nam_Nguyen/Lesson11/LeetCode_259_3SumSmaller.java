package Homework.Nam_Nguyen.Lesson11;

import java.util.Arrays;

public class LeetCode_259_3SumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int length = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < length - 1; i++) {
            int left = i + 1, right = length - 1;
            int k = target - nums[i];
            while(left < right) {
                if(nums[left] + nums[right] < k) {
                    res+=(right - left);
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_259_3SumSmaller prob = new LeetCode_259_3SumSmaller();
        int[] nums = {3,1,0,-2};
        int target = 4;
        prob.threeSumSmaller(nums, target);
    }
    
}
