package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_303_RangeOfQueryImmutable {

    private int[] sumArray;

    public LeetCode_303_RangeOfQueryImmutable(int[] nums) {
        int arraySize = nums.length;
        sumArray = new int[arraySize];
        sumArray[0] = nums[0];
        for (int i = 1; i < arraySize; i++) {
            sumArray[i] = sumArray[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0)   return sumArray[right];
        return sumArray[right] - sumArray[left - 1];
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        LeetCode_303_RangeOfQueryImmutable obj = new LeetCode_303_RangeOfQueryImmutable(nums);
        int param1 = obj.sumRange(1,3);
    }
}
