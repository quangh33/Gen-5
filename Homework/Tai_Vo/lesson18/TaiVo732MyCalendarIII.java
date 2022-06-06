package lesson18;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author taivt
 * @link https://leetcode.com/problems/my-calendar-iii/
 * @since 2022/06/06 23:17:39
 */
public class TaiVo732MyCalendarIII {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20)); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
        System.out.println(myCalendarThree.book(50, 60)); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
        System.out.println(myCalendarThree.book(10, 40)); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
        System.out.println(myCalendarThree.book(5, 15)); // return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
        System.out.println(myCalendarThree.book(5, 10)); // return 3
        System.out.println(myCalendarThree.book(25, 55)); // return 3
    }

    // n: the number of calls
    // Space Complexity: O(n)
    // Time Complexity: O(n ^ 2)
    private static class MyCalendarThree {
        private final Map<Integer, Integer> booking;

        public MyCalendarThree() {
            booking = new TreeMap<>();
        }

        public int book(int start, int end) {
            booking.put(start, booking.getOrDefault(start, 0) + 1);
            booking.put(end, booking.getOrDefault(end, 0) - 1);
            int maxKBooking = 0;
            int curBooking = 0;
            for (Map.Entry<Integer, Integer> entry : booking.entrySet()) {
                curBooking += entry.getValue();
                maxKBooking = Math.max(maxKBooking, curBooking);
            }
            return maxKBooking;
        }
    }
}
