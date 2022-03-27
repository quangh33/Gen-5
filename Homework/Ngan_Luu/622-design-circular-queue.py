https://leetcode.com/problems/design-circular-queue/
class MyCircularQueue:
    def __init__(self, k: int):
        self.size=k
        self.Queue=[]
        
    def enQueue(self, value: int) -> bool:
        if not self.isFull():
            self.Queue.append(value)
            print(self.Queue)
            return True
        else:
            return False

    def deQueue(self) -> bool:
        if not self.isEmpty():
            self.Queue.pop(0)
            print(self.Queue)
            return True
        else:
            return False

    def Front(self) -> int:
        if len(self.Queue)>0:
            return self.Queue[0]
        else:
            return -1
        
    def Rear(self) -> int:
        if len(self.Queue)>0:
            return self.Queue[-1]
        else:
            return -1
        
    def isEmpty(self) -> bool:
        return len(self.Queue)==0

    def isFull(self) -> bool:
        return len(self.Queue)==self.size