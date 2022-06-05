# 543. https://leetcode.com/problems/diameter-of-binary-tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.tree_diameter=0
        def dfs(node):
            if not(node):
                return -1
            elif not(node.left) and not(node.right):
                return 0
            else:
                left_height=dfs(node.left)
                right_height=dfs(node.right)
                node_diameter=left_height+right_height+2
                self.tree_diameter=max(self.tree_diameter,node_diameter)
                height=max(left_height,right_height)+1
                return height
        dfs(root)
        return(self.tree_diameter)