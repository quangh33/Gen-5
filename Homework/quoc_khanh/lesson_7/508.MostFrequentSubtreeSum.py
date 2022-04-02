from collections import Counter
from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def __init__(self) -> None:
        self.sumToFreq = Counter()
        self.maxFreq = 0
    
    def count(self, node: Optional[TreeNode]):
        if node == None:
            return 0
        left = self.count(node.left)
        right = self.count(node.right)
        currSum = left + right + node.val
        if currSum in self.sumToFreq:
            self.sumToFreq[currSum] += 1
        else:
            self.sumToFreq[currSum] = 1
        self.maxFreq = max(self.maxFreq, self.sumToFreq[currSum])
        return currSum

    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        self.count(root)
        result = []
        for sum, freq in self.sumToFreq.items():
            if freq == self.maxFreq:
                result.append(sum)
        return result

def buildBinaryTree(nums: List[int]) -> TreeNode:
    nodes = Queue()
    root = TreeNode(nums[0])
    nodes.put(root)
    numIdx = 0
    length = len(nums)

    def next() -> int:
        nonlocal numIdx
        numIdx += 1
        return nums[numIdx] if numIdx < length else None

    while not nodes.empty() or numIdx < length - 1:
        node = nodes.get()
        leftValue = next()
        if leftValue:
            node.left = TreeNode(val=nums[numIdx])
            nodes.put(node.left)
        rightValue = next()
        if rightValue:
            node.right = TreeNode(val=nums[numIdx])
            nodes.put(node.right)
    return root

s = Solution()
root = buildBinaryTree([5,2,-3])
print(s.findFrequentTreeSum(root) == [2, -3, 4])
root = buildBinaryTree([5,2,-5])
print(s.findFrequentTreeSum(root) == [2])