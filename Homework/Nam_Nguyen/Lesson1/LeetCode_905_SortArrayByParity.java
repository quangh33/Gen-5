package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_905_SortArrayByParity {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < nums.length && nums[left]%2 == 0) left++;
            while (right >= 0 && nums[right]%2 == 1) right--;
            if(left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4,0,0,4,3,3};
        int[] res = sortArrayByParity(nums);
    }
}
