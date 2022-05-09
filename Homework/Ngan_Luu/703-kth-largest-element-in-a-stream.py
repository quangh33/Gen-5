# https://leetcode.com/problems/kth-largest-element-in-a-stream/
from heapq import heapify,heappush,heappushpop,heappop
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k=k
        self.kMinHeap=nums
        heapify(self.kMinHeap)
        while len(self.kMinHeap)>k:
            heappop(self.kMinHeap)
        
    def add(self, val: int) -> int:
        if len(self.kMinHeap)<self.k:
            heappush(self.kMinHeap,val)
        elif val > self.kMinHeap[0]:
            heappushpop(self.kMinHeap,val)
        return self.kMinHeap[0]