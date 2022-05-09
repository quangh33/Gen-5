#https://leetcode.com/problems/validate-binary-search-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
import sys
maxSize = sys.maxsize
minSize = -sys.maxsize - 1
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def isValidNode(node, min_value, max_value):
            if not node:
                return True
            if min_value<node.val and node.val<max_value:
                curr=True
            else:
                curr=False
            left=isValidNode(node.left,min_value,node.val)
            right=isValidNode(node.right,node.val,max_value)
            return curr and left and right
        return(isValidNode(root,-sys.maxsize-1,sys.maxsize))