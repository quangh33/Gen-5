package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_283_MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int last0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                swap(nums, i, last0);
                last0++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,0};
        moveZeroes(nums);
    }
}
