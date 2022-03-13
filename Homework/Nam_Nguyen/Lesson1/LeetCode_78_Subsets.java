package Homework.Nam_Nguyen.Lesson1;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());
        List<Integer> sum;
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            sum = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(getBit(i, j) == 1){
                    sum.add(nums[j]);
                }
            }
            result.add(sum);
        }
        return result;
    }

    public static int getBit(int x, int position) {
        return (x >> position) & 1;
    }

    public static void main(String[] args) {
        int num[] = {1,2,3};
        List<List<Integer>> result = subsets(num);
    }

}
