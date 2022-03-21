package lesson04.livecode;

/**
 * @author taivt
 * @link https://leetcode.com/problems/min-stack/
 * @since 2022/03/17 21:34:57
 */
public class LiveCode02DesignAStackOfInteger {
    public static void main(String[] args) {
        // stack:  top > 1 -> 2 -> 0 -> 4
//        MinStack minStack = new MinStack();
//        minStack.push(4);
//        minStack.push(0);
//        minStack.push(2);
//        minStack.push(1);

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin());  // return -2

//        minStack.print();
//        while (!minStack.isEmpty()) {
//            int top = minStack.top();
//            minStack.pop();
//            System.out.printf("value: %d%n", top);
//        }
    }

    private static class MinStack {

        private static class Node {
            int value;
            int minSoFar;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        Node top;

        void push(int value) {
            Node newNode = new Node(value);
            int minSoFar = top != null ? top.minSoFar : Integer.MAX_VALUE;
            newNode.minSoFar = Math.min(value, minSoFar);
            newNode.next = top;
            top = newNode;
        }

        void pop() {
            Node obsoleteTop = top;
            top = top.next;
            obsoleteTop.next = null;
        }

        int top() {
            return top.value;
        }

        int getMin() {
            return top.minSoFar;
        }

        boolean isEmpty() {
            return top == null;
        }

        void print() {
            Node iterator = top;
            while (!isEmpty() && iterator != null) {
                System.out.printf("(value: %d, minSoFar: %d) ", iterator.value, iterator.minSoFar);
                iterator = iterator.next;
            }
            System.out.println();
        }
    }
}
