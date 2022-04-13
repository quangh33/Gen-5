https://leetcode.com/problems/sliding-window-maximum/
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        output = []
        queue=[]
        for i in range(len(nums)):
            while queue and nums[queue[-1]] <= nums[i]:
                queue.pop()
            queue.append(i)

            while queue and i - queue[0] >= k:
                queue.pop(0)

            if i >= k - 1:
                output.append(nums[queue[0]])

        return output