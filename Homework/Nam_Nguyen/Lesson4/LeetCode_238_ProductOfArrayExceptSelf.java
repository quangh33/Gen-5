package Homework.Nam_Nguyen.Lesson4;

public class LeetCode_238_ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int[] left = new int[size];
        int[] prefix = new int[size];
     
        left[0]=1;
        for(int i=0; i<size-1; i++){
            left[i+1] = nums[i] * left[i];
        }

        prefix[size-1]=1;
        for(int i=size-1; i>0; i--){
            prefix[i-1] = prefix[i] * nums[i];
        }

        for(int i=0; i<size; i++){
            result[i] = left[i] * prefix[i];
        }
     
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
    }
    
}
