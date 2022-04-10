# 337. https://leetcode.com/problems/house-robber-iii/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not(node):
                return [0,0]
            left=dfs(node.left)
            right=dfs(node.right)
            rob_this_node=node.val+left[1]+right[1]
            not_rob_this_node=max(left)+max(right)
            return [rob_this_node,not_rob_this_node]
        return max(dfs(root))