from collections import deque


class MovingAverage:

    def __init__(self, size: int):
        self.deque = deque(maxlen=size)
        self.size = size
        self.total = 0

    def isDequeFull(self):
        return len(self.deque) == self.size

    def next(self, val: int) -> float:
        if self.isDequeFull():
            removedValue = self.deque.popleft()
            self.total -= removedValue
        self.total += val
        self.deque.append(val)
        return self.total / len(self.deque)

s = MovingAverage(3)
print(s.next(1) == 1)
print(s.next(10) == 5.5)
print(s.next(3) == 4.666666666666667)
print(s.next(5) == 6)