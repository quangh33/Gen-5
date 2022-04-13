# 404. https://leetcode.com/problems/sum-of-left-leaves/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
            
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        leftLeaves=[]
        def dfs(node,isLeft):
            if not(node):
                return None
            else:
                if node.left:
                    dfs(node.left,True)
                if node.right:
                    dfs(node.right,False)
                if not(node.left) and not(node.right) and isLeft:
                    leftLeaves.append(node.val)
        dfs(root,False)
        return sum(leftLeaves)