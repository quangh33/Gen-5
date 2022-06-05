import heapq
from typing import List

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.heap = nums
        self.k = k
        heapq.heapify(self.heap)
        self.resize()
    def resize(self):
        while len(self.heap) > self.k:
            heapq.heappop(self.heap)
    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        self.resize()
        return self.heap[0]

q = KthLargest(3, [4,5,8,2])
print(q.add(3) == 4)
print(q.add(5) == 5)
print(q.add(10) == 5)
print(q.add(9) == 8)
print(q.add(4) == 8)