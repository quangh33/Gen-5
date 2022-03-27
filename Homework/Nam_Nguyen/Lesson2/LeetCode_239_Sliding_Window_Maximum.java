package Homework.Nam_Nguyen.Lesson2;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_239_Sliding_Window_Maximum {

    static Deque<Integer> deque = new LinkedList<>();

    public static void push(int i, int[] nums) {
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
            deque.removeLast();
        }
        deque.addLast(i);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            push(i, nums);
            if(i >= k-1){
                result[count++] = nums[deque.getFirst()];
                if(deque.getFirst() <= i - k + 1)   deque.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 9, 8, 7, 6, 1, 9, 5, 0};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
    }
    
}
