package Homework.Nam_Nguyen.Lesson2;

public class LeetCode_215_KthLargestInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        return findSmallest(0, nums.length - 1, nums, nums.length + 1 - k);
    }

    public static int findSmallest(int low, int high, int[] nums, int k){
        int pivotLocation = partition(low, high, nums);
        if(pivotLocation == k - 1)
            return nums[pivotLocation];
        
        if(pivotLocation < k - 1){
            return findSmallest(pivotLocation + 1, high, nums, k);
        }else {
            return findSmallest(low, pivotLocation - 1, nums, k);
        }
    }

    public static int partition(int low, int high, int[] nums){

        int pivot = nums[high];
        int pivotLocation = low;
        int temp;
        for (int i = low; i <= high; i++) {
            if(nums[i] < pivot){
                temp = nums[i];
                nums[i] = nums[pivotLocation];
                nums[pivotLocation] = temp;
                pivotLocation++;
            }
        }

        temp = nums[high];
        nums[high] = nums[pivotLocation];
        nums[pivotLocation] = temp;

        return pivotLocation;
    }
    
    public static void main(String[] args) {
        int[] nums = {10, 8, 8};
        int k = 3;
        int res = findKthLargest(nums, k);
    }
}
