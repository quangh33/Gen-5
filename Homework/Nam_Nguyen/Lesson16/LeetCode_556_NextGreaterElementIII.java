package Homework.Nam_Nguyen.Lesson16;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_556_NextGreaterElementIII {

    boolean nextPermutation(int[] nums){
        int i = nums.length -1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i==0) {
            return false;
        }else{
            int j = i;
            while(j < nums.length && nums[j] > nums[i-1]){
                j++;
            }
            int tmp = nums[i-1];
            nums[i-1] = nums[j-1];
            nums[j-1] = tmp;
            reverse(nums, i, nums.length-1);  
        }
        return true;
    }

    void reverse(int nums[], int left, int right)
    {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        while(n > 0) {
            nums.add(0, n%10);
            n/=10;
        }
        int[] input = nums.stream().mapToInt(i->i).toArray();
        boolean hasNext = nextPermutation(input);
        if(!hasNext)    return -1;
        long res = 0;
        for (int i : input) {
            res = res*10 + i;
        }
        if(res > Integer.MAX_VALUE)    return -1;
        return (int) res;
    }

    public static void main(String[] args) {
        LeetCode_556_NextGreaterElementIII prob = new LeetCode_556_NextGreaterElementIII();
        int n = 21;
        prob.nextGreaterElement(n);
    }
}
