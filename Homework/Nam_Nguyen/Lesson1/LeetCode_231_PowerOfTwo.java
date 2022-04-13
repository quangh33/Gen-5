package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_231_PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0)  return false;
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println("res : "+isPowerOfTwo(n));
    }
}
