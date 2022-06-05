from typing import List, Optional


from queue import Queue

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        queue = Queue()
        queue.put(root)
        leftMost = None
        while not queue.empty():
            length = queue.qsize()
            for i in range(length):
                node = queue.get()
                if i == 0:
                    leftMost = node.val
                if node.left:
                    queue.put(node.left)
                if node.right:
                    queue.put(node.right)
        return leftMost

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
root = buildBinaryTree([2,1,3])
print(s.findBottomLeftValue(root) == 1)
root = buildBinaryTree([1,2,3,4,None,5,6,None,None,7])
print(s.findBottomLeftValue(root) == 7)
