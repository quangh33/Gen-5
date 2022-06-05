package HomeWorkLastAlgoLesson;

import java.util.TreeMap;

public class MyCalendarThree {
    TreeMap<Integer, Integer> calendar;

    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }

    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);

        int res = 0;
        int count = 0;

        for (int freq : calendar.values()) {
            count += freq;
            res = Math.max(res, count);
        }

        return res;
    }
}
