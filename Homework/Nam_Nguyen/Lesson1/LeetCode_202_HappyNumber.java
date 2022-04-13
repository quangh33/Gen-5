package Homework.Nam_Nguyen.Lesson1;

import java.util.HashSet;

public class LeetCode_202_HappyNumber {

    public static boolean isHappy(int n) {
        HashSet setOfOccurence = new HashSet();
        while(n > 1){
            if (setOfOccurence.contains(n)) return false;
            setOfOccurence.add(n);
            n = sumOfSquares(n);
        }
        return true;
    }

    public static int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10)*(n%10);
            n/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
