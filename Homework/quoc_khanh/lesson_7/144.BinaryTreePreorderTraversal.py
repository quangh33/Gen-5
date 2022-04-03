from distutils.command.build import build
from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def visit(self, node: Optional[TreeNode], path: List[int]):
        if node == None:
            return
        path.append(node.val)
        self.visit(node.left, path)
        self.visit(node.right, path)

    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        path = []
        self.visit(root, path)
        return path

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
root = buildBinaryTree([1,None,2,3])
print(s.preorderTraversal(root) == [1,2,3])
root = buildBinaryTree([1,2,3,4,5])
print(s.preorderTraversal(root) == [1,2,4,5,3])