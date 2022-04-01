package Homework.Nam_Nguyen.Lesson4;

public class MinStack {
    int[] stack;
    int capacity = 0;
    public MinStack() {
        // Constraint: At most 3 * 10^4 calls will be made to push, pop, top, and getMin
        stack = new int[30000];
    }
    
    public void push(int val) {
        stack[capacity++] = val;
    }
    
    public void pop() {
        capacity--;
    }
    
    public int top() {
        // Constraint: Methods pop, top and getMin operations will always be called on non-empty stacks.
        // so no need to check stack is empty before get top of stack
        return stack[capacity-1];
    }
    
    public int getMin() {
        int k = capacity;
        int min = stack[--k];
        while(k >= 0){
            if(stack[k] < min) {
                min = stack[k];
            }
            k--;
        }
        return min;
    }
}
