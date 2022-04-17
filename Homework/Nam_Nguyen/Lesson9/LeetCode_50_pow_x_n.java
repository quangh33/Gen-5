package Homework.Nam_Nguyen.Lesson9;

public class LeetCode_50_pow_x_n {

    public static double myPow(double x, int n) {
        int originalN = n;
        if(n < 0){
            if(n == Integer.MIN_VALUE) {
                n++;
            }
            n = -n;
            x = 1/x;
        }
        if(n == 0)  return 1;
        if(n == 1)  return x;
        double pow = myPow(x, n/2);
        if(originalN%2 == 0)
            return pow * pow;    
        return pow * pow * x;
    }

    public static void main(String[] args) {
        System.out.println("res: "+myPow(-1.0, -3));
    }
}
