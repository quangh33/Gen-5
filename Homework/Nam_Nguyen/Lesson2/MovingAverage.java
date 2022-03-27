package Homework.Nam_Nguyen.Lesson2;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    int sum = 0;
    Queue<Integer> queue = new LinkedList<>();
    int capacity;
    
    public MovingAverage(int size) {
      capacity = size;
    }
  
    public double next(int val) {
      queue.add(val);
      sum+= val;
      if (queue.size() > capacity) {
        sum-= this.queue.remove();
      }
      return ((double) sum)/queue.size();
    }
    
}
