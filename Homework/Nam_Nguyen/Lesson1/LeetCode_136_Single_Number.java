package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_136_Single_Number {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int element: nums) {
            result ^= element;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4};
        int r = 4 ^ 1 ^ 2 ^ 1 ^ 2;
        System.out.println("res : "+singleNumber(arr));
    }
}
