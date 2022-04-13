144. https://leetcode.com/problems/binary-tree-preorder-traversal
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res=[]
        def preOrder(node):
            if not(node):
                return
            res.append(node.val)
            
            preOrder(node.left)
                
            preOrder(node.right)
        preOrder(root)
        return res
        