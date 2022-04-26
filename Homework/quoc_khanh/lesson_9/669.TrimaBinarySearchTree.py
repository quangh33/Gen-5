# Definition for a binary tree node.
from queue import Queue
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        if root == None:
            return None
        if root.val < low:
            return self.trimBST(root.right, low, high)
        if root.val > high:
            return self.trimBST(root.left, low, high)
        root.left = self.trimBST(root.left, low, high)
        root.right = self.trimBST(root.right, low, high)
        return root

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

def inorder(root: TreeNode) -> List[int]:
    left, right = [], []
    if root.left != None:
        left = inorder(root.left)
    if root.right != None:
        right = inorder(root.right)
    return [*left, root.val, *right]

# s = Solution()
# root = buildBinaryTree([1,0,2])
# root = s.trimBST(root, 1, 2)
# print(inorder(root) == [1,2])
s = Solution()
root = buildBinaryTree([3,0,4,None,2,None,None,1])
print(inorder(root))
root = s.trimBST(root, 1, 3)
print(inorder(root) == [1,2,3])