# 1372. https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        def dfs(node,prevDirection):
            if not(node):
                return -1
            left=dfs(node.left,'left')
            right=dfs(node.right,'right')
            longestZigZag[0]=max(longestZigZag[0],max(left,right)+1)
            if prevDirection=='left':
                return right+1
            else:
                return left+1
        longestZigZag=[0]
        dfs(root,'right')
        return longestZigZag[0]