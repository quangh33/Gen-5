package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_238_ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] result = new int[nums.length];
     
        left[0]=1;
        prefix[nums.length-1]=1;
     
        for(int i=0; i<nums.length-1; i++){
            left[i+1] = nums[i] * left[i];
        }

        for(int i=nums.length-1; i>0; i--){
            prefix[i-1] = prefix[i] * nums[i];
        }

        for(int i=0; i<nums.length; i++){
            result[i] = left[i] * prefix[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        int[] res = productExceptSelf(nums);
    }
    
}
