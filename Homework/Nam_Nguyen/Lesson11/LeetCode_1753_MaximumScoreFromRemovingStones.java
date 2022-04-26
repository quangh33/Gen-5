package Homework.Nam_Nguyen.Lesson11;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode_1753_MaximumScoreFromRemovingStones {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public int maximumScore(int a, int b, int c) {
        int res = 0;
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);
        while(isValid(a, b, c)) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            res++;
            a = first - 1;
            b = second - 1;
            c = maxHeap.peek();
            maxHeap.add(a);
            maxHeap.add(b);
        }
        return res;
    }

    private boolean isValid(int a, int b, int c) {
        return (a > 0 && b > 0) || (b > 0 && c > 0) || (a > 0 && c > 0);
    }

    public static void main(String[] args) {
        int a = 4, b = 4, c = 6;
        LeetCode_1753_MaximumScoreFromRemovingStones solution = new LeetCode_1753_MaximumScoreFromRemovingStones();
        System.out.println(solution.maximumScore(a, b, c));
    }
    
}
