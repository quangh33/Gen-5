# 687. https://leetcode.com/problems/longest-univalue-path/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        def dfs(node,prev):
            if not(node):
                return 0
            left=dfs(node.left,node.val)
            right=dfs(node.right,node.val)
            longestPath[0]=max(longestPath[0],left+right)
            if node.val==prev:
                return max(left,right)+1
            else:
                return 0
        longestPath=[0]
        if root:
            dfs(root,root.val)
            return longestPath[0]
        else:
            return 0