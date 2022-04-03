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
        self.maxDiameter = 0

    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        if root.left == None and root.right == None:
            return 0
        self.findMaxDiameter(root)
        return self.maxDiameter

    def findMaxDiameter(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return -1
        leftSubtreeDiameter = self.findMaxDiameter(root.left)
        rightSubtreeDiameter = self.findMaxDiameter(root.right)

        # currentDiameter includes current node and it's subtree
        currentDiameter = leftSubtreeDiameter + rightSubtreeDiameter + 2

        self.maxDiameter = max(self.maxDiameter, currentDiameter)

        # here we try to take just one of the two subtrees for consideration at the parent of this node.
        return max(leftSubtreeDiameter, rightSubtreeDiameter) + 1

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