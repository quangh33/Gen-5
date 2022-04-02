# Definition for a binary tree node.
from queue import Queue
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        self.max = 0

class Solution:
    def __init__(self) -> None:
        self.max = 0

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 0
        self.find(root)
        return self.max

    def find(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        left = self.find(root.left)
        right = self.find(root.right)
        self.max = max(self.max, left + right)
        return max(left, right) + 1

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
root = buildBinaryTree([1,2])
print(s.diameterOfBinaryTree(root) == 1)