from queue import Queue
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self) -> str:
        return self.val

class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        leftSum = 0
        if root == None:
            return leftSum
        if root.left:
            leftSum += root.left.val if not root.left.left and not root.left.right else 0
            leftSum += self.sumOfLeftLeaves(root.left)
        if root.right:
            leftSum += self.sumOfLeftLeaves(root.right)
        return leftSum

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
# root = buildBinaryTree([3,9,20,None,None,15,7])
# print(s.sumOfLeftLeaves(root) == 24)
# root = buildBinaryTree([1])
# print(s.sumOfLeftLeaves(root) == 0)
root = buildBinaryTree([1,2,3,4,5])
print(s.sumOfLeftLeaves(root) == 4)
