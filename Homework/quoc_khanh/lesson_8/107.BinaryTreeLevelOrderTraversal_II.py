from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        queue = Queue()
        queue.put(root)
        result = []
        while not queue.empty():
            levelValue = []
            levelLength = queue.qsize()
            for _ in range(levelLength):
                node = queue.get()
                levelValue.append(node.val)
                if node.left:
                    queue.put(node.left)
                if node.right:
                    queue.put(node.right)
            result.append(levelValue)
        result.reverse()
        return result

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
root = buildBinaryTree([3,9,20,None,None,15,7])
print(s.levelOrderBottom(root))