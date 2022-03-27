class MyCircularQueue:

    def __init__(self, k: int):
        self.array = [0] * k
        self.length = 0
        self.capacity = k
        self.rear = -1
        self.front = 0

    def enQueue(self, value: int) -> bool:
        '''Insert at rear'''
        if self.isFull():
            return False
        else:
            self.rear = (self.rear + 1) % self.capacity
            self.array[self.rear] = value
            self.length += 1
            return True

    def deQueue(self) -> bool:
        '''Delete at front'''
        if self.isEmpty():
            return False
        else:
            self.front = (self.front + 1) % self.capacity
            self.length -= 1
            return True
        

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.array[self.front]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.array[self.rear]

    def isEmpty(self) -> bool:
        return self.length == 0

    def isFull(self) -> bool:
        return self.length == self.capacity

s = MyCircularQueue(3)
print(s.enQueue(1) == True)
print(s.enQueue(2) == True)
print(s.enQueue(3) == True)
print(s.enQueue(4) == True)
print(s.Rear() == 3)
print(s.Rear())