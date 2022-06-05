# https://leetcode.com/problems/inorder-successor-in-bst/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        arr=[]
        self.res=None
        preNode=[None]
        def dfs(node):
            if not node:
                return
            dfs(node.left)
            if preNode[-1]==p.val:
                self.res=node
            preNode[-1]=node.val
            arr.append(node.val)
            dfs(node.right)
        dfs(root)
        return self.res