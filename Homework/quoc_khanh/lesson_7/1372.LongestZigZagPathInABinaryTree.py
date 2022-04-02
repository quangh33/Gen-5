from distutils.command.build import build
from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self) -> None:
        self.max = 0
        self.stack = []

    def find(self, root: Optional[TreeNode]):
        if root == None:
            return -1, -1, -1
        lLeftLen, lRightLen, lLongestSoFar = self.find(root.left)
        rLeftLen, rRightLen, rLongestSoFar = self.find(root.right)
        newLeftLen = lRightLen + 1
        newRightLen = rLeftLen + 1
        return newLeftLen, newRightLen, max(newLeftLen, newRightLen, lLongestSoFar, rLongestSoFar)
        

    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        _, _, longest = self.find(root)
        return longest

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
# root = buildBinaryTree([1,1,1,None,1,None,None,1,1,None,1])
# print(s.longestZigZag(root) == 4)
root = buildBinaryTree([1,None,1,1,1,None,None,1,1,None,1,None,None,None,1,None,1])
s.stack.append((1, 'ANY'))
print(s.longestZigZag(root) == 3)