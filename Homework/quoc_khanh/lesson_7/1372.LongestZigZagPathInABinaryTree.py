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

    def find(self, current: Optional[TreeNode]):
        '''
            Returns:
                @left: zigzac length of the subtree including the current node and it's left subtree
                @right: zigzac elngth of the subtree including the current node and it's right subtree
        '''
        if current == None:
            return -1, -1

        left_leftNode, right_leftNode = self.find(current.left)
        # right_leftNode: zigzag length of the subtree including current.left,
        # and all children of current.left.right.

        # left_leftNode: we ignore subtree including current.left and current.left.left,
        # because it cannot form a zigzag.

        left_rightNode, right_rightNode = self.find(current.right)
        # right_rightNode: zigzag length of the subtree including current.right,
        # and all the children of current.right.left

        # right_rightNode: likewise, we ignore subtree including current.right and current.right.right,
        # because it cannot form a zigzag.

        currentLeft = right_leftNode + 1
        # from current node, visit left child, visit right node of the left child,...

        currentRight = left_rightNode + 1
        # from current node, visit right child, visit left node of the right child,...

        self.max = max(currentLeft, currentRight, self.max)
        return currentLeft, currentRight
        

    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.find(root)
        return self.max

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
root = buildBinaryTree([1,1,1,None,1,None,None,1,1,None,1])
print(s.longestZigZag(root) == 4)
s = Solution()
root = buildBinaryTree([1,None,1,1,1,None,None,1,1,None,1,None,None,None,1,None,1])
print(s.longestZigZag(root) == 3)