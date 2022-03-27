https://leetcode.com/problems/moving-average-from-data-stream/
class MovingAverage:

    def __init__(self, size: int):
        self.size=size
        self.Queue=[]

    def next(self, val: int) -> float:
        if len(self.Queue)>=self.size:
            self.Queue.pop(0)
        self.Queue.append(val)
        return float(sum(self.Queue)/len(self.Queue))