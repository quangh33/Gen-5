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

    def findLongestUnivaluePath(self, node: Optional[TreeNode]):
        '''
            Returns:
                @num: int
                @len: int
                    @len is length of path that consists only number @num.
        '''
        if not node:
            return None, 0
        lengthIncludeCurrent = 0

        # calculate length
        leftNumber, leftLen = self.findLongestUnivaluePath(node.left)
        rightNumber, rightLen = self.findLongestUnivaluePath(node.right)

        # update length
        if leftNumber == node.val:
            lengthIncludeCurrent += leftLen + 1

        if rightNumber == node.val:
            lengthIncludeCurrent += rightLen + 1

        # update max length
        self.longest = max(self.longest, lengthIncludeCurrent)

        if leftNumber == node.val and rightNumber == node.val:
            # if both left child and right child values equal to current value,
            # then we only take the subtree that has logger length.
            return node.val, max(leftLen, rightLen) + 1
        else:
            # if only one child or none of them has value equals to current value,
            # them simply return the length, this length has updated.
            return node.val, lengthIncludeCurrent
        

    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        self.findLongestUnivaluePath(root)
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
