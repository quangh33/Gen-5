from typing import List

UP = 'up'
DOWN = 'down'

class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        '''
            two pointers
        '''
        length = len(arr)
        front = 0
        maxLength = 0

        def indexOk() -> bool:
            return front + 1 < length

        while indexOk():
            if arr[front] < arr[front + 1]:
                back = front
                while indexOk() and arr[front] < arr[front + 1]: # go up to the peak
                    front += 1
                if indexOk() and arr[front] > arr[front + 1]:
                    while indexOk() and arr[front] > arr[front + 1]:
                        front += 1
                    sublength = front - back + 1
                    maxLength = max(maxLength, sublength)
                    continue
            front += 1
        return maxLength

    def longestMountain1(self, arr: List[int]) -> int:
        if len(arr) < 3:
            return 0
        arr.append(arr[-1])
        direction = None
        upAndDown = 1
        maxLength = 0
        subLength = 0

        def isMountain(upAndDown: int) -> bool:
            return upAndDown == 2

        for idx, num in enumerate(arr[:-1]):
            if direction != None:
                subLength += 1
            if num > arr[idx + 1] and direction == UP: # UP hill to DOWN hill
                upAndDown += 1
                direction = DOWN
            if num <= arr[idx + 1] and direction == DOWN: # DOWN hill to UP hill
                if isMountain(upAndDown):
                    maxLength = max(maxLength, subLength)
                direction = UP
                subLength = 1
                upAndDown = 1
            if num == arr[idx + 1] and direction != None: # from DOWN hill or UP hill to flat
                direction = None
                subLength = 0
                upAndDown = 1
            if num > arr[idx + 1] and direction == None: # from flat to DOWN hill
                direction = DOWN
                subLength = 1
            if num < arr[idx + 1] and direction == None: # from flat to UP hill
                direction = UP
                subLength = 1
        return maxLength

s = Solution()
print(s.longestMountain([875,884,239,731,723,685])==4)
print(s.longestMountain([2,1,4,7,3,2,5])==5)
print(s.longestMountain([1,2])==0)
print(s.longestMountain([1,2,3])==0)
print(s.longestMountain([3,2,1])==0)
print(s.longestMountain([1,2,0])==3)
print(s.longestMountain([2,2,2])==0)
print(s.longestMountain([1,2,3,4,5,4,3,2,1])==9)
print(s.longestMountain([5,4,3,2,1,2,3,4,5])==0)
print(s.longestMountain([3,2,1,2,3,2,1,0])==6)
print(s.longestMountain([5,5,5,5,5,4,3,2,1])==0)
print(s.longestMountain([5,5,5,5,5,4,3,2,1,2,3,4,5])==0)
print(s.longestMountain([1,2,3,4,5,5,5,5,5,5,4,3,2,1])==0)
print(s.longestMountain([3,3,3,3,3,4,5,6,5,4,3,3,3,3])==7)
