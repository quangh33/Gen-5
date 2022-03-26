package lesson04;

/**
 * @author taivt
 * @link https://leetcode.com/problems/min-stack/
 * @since 2022/03/17 21:34:57
 */
public class TaiVo155MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.print();
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin());  // return -2
    }

    // Space Complexity: O(n)
    // Time Complexity: O(1)
    private static class MinStack {

        private static class Node {
            int value;
            int minSoFar;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        private Node top;

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
