package Homework.Nam_Nguyen.Lesson4;

public class MinStack {
    public class Pair {
        private int value;
        private int minSoFar;

        Pair(int value, int minSoFar){
            this.value = value;
            this.minSoFar = minSoFar;
        }
    }

    Pair[] stack;
    int capacity = 0;
    public MinStack() {
        // Constraint: At most 3 * 10^4 calls will be made to push, pop, top, and getMin
        stack = new Pair[30000];
    }
    
    public int min(int a, int b) {
        if(a < b)
            return a;
        return b;
    }    
    public void push(int val) {
        int minSoFar;
        if(capacity > 0)
            minSoFar = stack[capacity-1].minSoFar;
        else 
            minSoFar = Integer.MAX_VALUE;
        minSoFar = min(minSoFar, val);
        Pair element = new Pair(val, minSoFar);
        stack[capacity++] = element;
    }
    
    public void pop() {
        capacity--;
    }
    
    public int top() {
        // Constraint: Methods pop, top and getMin operations will always be called on non-empty stacks.
        // so no need to check stack is empty before get top of stack
        return stack[capacity-1].value;
    }
    
    public int getMin() {
        return stack[capacity-1].minSoFar;
    }
}
