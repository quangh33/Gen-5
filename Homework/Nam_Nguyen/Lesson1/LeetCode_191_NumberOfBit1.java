package Homework.Nam_Nguyen.Lesson1;

public class LeetCode_191_NumberOfBit1 {

    public static int hammingWeight(int n) {
        int numberOfBit1 = 0;
        for (int i = 0; i < 32; i++) {
            if(((n >> i) & 1) == 1)
                numberOfBit1++;
        }
        return numberOfBit1;
    }

    public static void main(String[] args) {
        int n = -5;
        System.out.println("res : "+hammingWeight(n));
    }
}
