from queue import Queue
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        robRoot, notRobRoot = self.robNow(root)
        return max(robRoot, notRobRoot)

    def robNow(self, current: Optional[TreeNode]):
        if current == None:
            return 0, 0
        robLeft, notRobLeft = self.robNow(current.left)
        robRight, notRobRight = self.robNow(current.right)
        robCurrent = current.val + notRobLeft + notRobRight
        notRobCurrent = max(robLeft, notRobLeft) + max(robRight, notRobRight)
        return robCurrent, notRobCurrent

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
root = buildBinaryTree([3,2,3,None,3,None,1])
print(s.rob(root) == 7)
root = buildBinaryTree([3,4,5,1,3,None,1])
print(s.rob(root) == 9)
root = buildBinaryTree([4,1,None,2,None,3])
print(s.rob(root) == 7)