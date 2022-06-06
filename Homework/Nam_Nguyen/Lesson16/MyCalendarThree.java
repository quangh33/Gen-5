package Homework.Nam_Nguyen.Lesson16;

import java.util.Map;
import java.util.TreeMap;

// 732. My Calendar III
public class MyCalendarThree {

    public MyCalendarThree() {
    
    }

    private Map<Integer, Integer> books = new TreeMap<>();
    public int book(int start, int end) {
        books.put(start, books.getOrDefault(start, 0)+1);
        books.put(end, books.getOrDefault(end, 0)-1);
        int count = 0;
        int maxBooking = 0;
        for(int value : books.values()) {
            count+=value;
            maxBooking = Math.max(count, maxBooking);
        }
        return maxBooking;
    }
    
    public static void main(String[] args) {
        MyCalendarThree obj = new MyCalendarThree();
        int[][] arr = {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        for (int[] is : arr) {
            int start = is[0];
            int end = is[1];
            int res = obj.book(start,end);
            System.out.println(res);
        }
    }
}
