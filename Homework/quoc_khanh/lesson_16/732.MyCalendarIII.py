import collections


class MyCalendarThree:

    def __init__(self):
        self.data = {}

    def save(self, time, delta):
        if time in self.data:
            self.data[time] += delta
        else:
            self.data[time] = delta

    def book(self, start: int, end: int) -> int:
        maxOverlap = 0
        self.save(start, 1)
        self.save(end, -1)
        currentEvent = 0
        for time in sorted(self.data):
            currentEvent += self.data[time]
            maxOverlap = max(maxOverlap, currentEvent)
        return maxOverlap

s = MyCalendarThree()
print(s.book(10, 20) == 1)
print(s.book(50, 60) == 1)
print(s.book(10, 40) == 2)
print(s.book(5, 15) == 3)
print(s.book(5, 10) == 3)
print(s.book(25, 55) == 3)