package lesson3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taivt
 * @link https://leetcode.com/problems/moving-average-from-data-stream/
 * @since 2022/03/25 02:23:52
 */
public class TaiVo346MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }

    private static class MovingAverage {
        private final Queue<Integer> queue;
        private final int size;
        private int currentSum = 0;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                Integer removedVal = queue.poll();
                currentSum -= removedVal;
            }
            currentSum += val;
            queue.add(val);
            return (double) currentSum / queue.size();
        }
    }
}
