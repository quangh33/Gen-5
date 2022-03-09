from typing import List


class Solution:
    def swap(self, nums: List[int], index1: int, index2: int):
        nums[index1], nums[index2] = nums[index2], nums[index1]

    def moveZeroes(self, nums: List[int]) -> None:
        ''' using snow ball algo :D
            explaination: https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
        '''
        leftMostZeroIdx = None
        for index, num in enumerate(nums):
            if num == 0 and leftMostZeroIdx == None:
                leftMostZeroIdx = index
            if num != 0 and leftMostZeroIdx != None:
                self.swap(nums, leftMostZeroIdx, index)
                leftMostZeroIdx += 1
        print(nums)

    def moveZeroes1(self, nums: List[int]) -> None:
        """
        another way using two pointer
        """
        read_pointer = 1
        write_pointer = 0
        while read_pointer < len(nums):
            if nums[write_pointer] != 0:
                write_pointer += 1
                read_pointer = write_pointer + 1
            else:
                if nums[read_pointer] == 0:
                    read_pointer += 1
                else:
                    nums[write_pointer] = nums[read_pointer]
                    nums[read_pointer] = 0
                    read_pointer += 1
                    write_pointer += 1

s = Solution()
print(s.moveZeroes([0,1,0,3,12]))