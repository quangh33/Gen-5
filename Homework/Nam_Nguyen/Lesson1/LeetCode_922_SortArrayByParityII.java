package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_922_SortArrayByParityII {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int oddIndex=1;
        for (int evenIndex = 0; evenIndex < nums.length; evenIndex += 2)
            if (nums[evenIndex] % 2 == 1) {
                while (nums[oddIndex] % 2 == 1)
                    oddIndex += 2;
                swap(nums, evenIndex, oddIndex);
            }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4,0,0,4,3,3};
        int[] res = sortArrayByParityII(nums);
    }
}
