# Definition for a binary tree node.
from queue import Queue
from typing import List, Optional

MIN_VAL = - 2 ** 31
MAX_VAL = 2 ** 31 - 1

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def check(self, node: Optional[TreeNode], localMinVal: int, localMaxVal: int) -> bool:
        if node == None:
            return True
        if node.val < localMaxVal and node.val > localMinVal:
            return self.check(node.left, localMinVal, node.val) and self.check(node.right, node.val, localMaxVal)
        return False
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.check(root.left, MIN_VAL - 1, root.val) and self.check(root.right, root.val, MAX_VAL + 1)

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
root = buildBinaryTree([2])
print(s.isValidBST(root) == True)
root = buildBinaryTree([2,1])
print(s.isValidBST(root) == True)
root = buildBinaryTree([2,None, 3])
print(s.isValidBST(root) == True)
root = buildBinaryTree([2,1,3])
print(s.isValidBST(root) == True)
root = buildBinaryTree([5,1,4,None,None,3,6])
print(s.isValidBST(root) == False)