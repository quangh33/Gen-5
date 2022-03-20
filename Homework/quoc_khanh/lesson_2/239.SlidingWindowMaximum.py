from typing import List
from collections import deque

LAST_INDEX = -1

class Solution:
    def __init__(self) -> None:
        self.WINDOW_SIZE = None
        self.window = None

    def isWindowFull(self) -> bool:
        return len(self.window) == self.WINDOW_SIZE

    def appendToWindow(self, value: int) -> bool:
        while len(self.window) > 0 and self.window[LAST_INDEX] < value:
            self.window.pop()
        return self.window.append(value)

    def maxInWindow(self) -> int:
        return self.window[0]

    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        self.WINDOW_SIZE = k
        self.window = deque(iterable=[],maxlen=self.WINDOW_SIZE)
        maxValues = []
        # first window
        for num in nums[:self.WINDOW_SIZE]:
            self.appendToWindow(num)
        maxValues.append(self.maxInWindow())
        # window after that
        for i in range(self.WINDOW_SIZE, len(nums)):
            if nums[i - self.WINDOW_SIZE] == self.window[0]:
                self.window.popleft()
            if not self.isWindowFull():
                self.appendToWindow(nums[i])
            else:
                self.appendToWindow(nums[i])
            maxValues.append(self.maxInWindow())
        return maxValues

s = Solution()
print(s.maxSlidingWindow([1,3,1,2,0,5], 3) == [3,3,2,5])
print(s.maxSlidingWindow([7,2,4], 2) == [7,4])
print(s.maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3) == [3,3,5,5,6,7])
print(s.maxSlidingWindow([1],1) == [1])
