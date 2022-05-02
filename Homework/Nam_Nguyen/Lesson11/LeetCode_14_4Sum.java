package Homework.Nam_Nguyen.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_14_4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = target - nums[i] - nums[j];
                int left = j + 1;
                int right = len - 1;
                while(left < right) {
                    if(nums[left] + nums[right] == k) {
                        resultSet.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < len - 1 && nums[left+1] == nums[left]) left++;
                        while(right > 0 && nums[right - 1] == nums[right]) right--;
                        left++;
                        right--;
                    }else if(nums[left] + nums[right] < k) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        res.addAll(resultSet);
        return res;
    }
    
    public static void main(String[] args) {
        LeetCode_14_4Sum prob = new LeetCode_14_4Sum();
        int[] nums = {2,2,2,2,2};
        int target = 8;
        System.out.println(prob.fourSum(nums, target));
    }
}
