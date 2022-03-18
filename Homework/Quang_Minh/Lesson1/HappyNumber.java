class HappyNumber {
    public boolean isHappy(int n) {
        int fastPointer = n;
        int slowPointer = n;
        while (true) {
            fastPointer = sumSquare(sumSquare(fastPointer));
            slowPointer = sumSquare(slowPointer);
            if (slowPointer == 1 || fastPointer == 1) return true;
            if (slowPointer == fastPointer) return false;
        }
    }

    private int sumSquare(int input) {
        int result = 0;
        while (input > 0) {
            result += (input % 10) * (input % 10);
            input /= 10;
        }
        return result;
    }
    
}