package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_153_FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        if(nums.length == 1 || nums[0] < nums[nums.length - 1]) // ascending, not be rotated
            return nums[0];
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]) { // is the rotated point
                return nums[mid+1];
            }
            if(nums[mid] > nums[0]) {
                low = mid;
            } else {
                high = mid;
            }

        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,1,2,3};
        System.out.println("Res: "+findMin(nums));
    }
    
}
