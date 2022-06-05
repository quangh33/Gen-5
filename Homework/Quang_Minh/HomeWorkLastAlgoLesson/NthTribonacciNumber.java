package HomeWorkLastAlgoLesson;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int num0 = 0, num1 = 1, num2 = 1, num = 0;
        if(n == 0) return 0;
        if(n < 3) return 1;
        for(int i = 3; i <= n ; i++) {
            num = num0 + num1 + num2;
            num0 = num1;
            num1 = num2;
            num2 = num;
        }
        return num;
    }
}
