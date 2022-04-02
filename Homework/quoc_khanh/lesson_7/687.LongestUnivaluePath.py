from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def __init__(self) -> None:
        self.longest = 0

    def count(self, node: Optional[TreeNode]):
        if not node:
            return None, 0
        length = 0
        leftNumber, leftLen = self.count(node.left)
        if leftNumber == node.val:
            length += leftLen + 1
        rightNumber, rightLen = self.count(node.right)
        if rightNumber == node.val:
            length += rightLen + 1
        self.longest = max(self.longest, length)

        if leftNumber == node.val and rightNumber == node.val:
            return node.val, max(leftLen, rightLen) + 1
        else:
            return node.val, length
        

    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        self.count(root)
        return self.longest
        
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
root = buildBinaryTree([5,4,5,1,1,5])
print(s.longestUnivaluePath(root) == 2)
root = buildBinaryTree([1,4,5,4,4,5])
print(s.longestUnivaluePath(root) == 2)
root = buildBinaryTree([1,1,3,1,1])
print(s.longestUnivaluePath(root) == 2)
