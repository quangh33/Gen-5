from queue import Queue
from typing import List, Optional

MAX_VAL = 10 ** 5 + 1

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def findSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        if root == None:
            return TreeNode(MAX_VAL)
        if root.val > p.val:
            res = self.findSuccessor(root.left, p)
            if res.val < root.val:
                return res
            return root
        if root.val == p.val:
            return self.findSuccessor(root.right, p)
        if root.val < p.val:
            return self.findSuccessor(root.right, p)

    def inorderSuccessor(self, root: TreeNode, p: TreeNode) -> Optional[TreeNode]:
        res = self.findSuccessor(root, p)
        if res.val == MAX_VAL:
            return None
        return res
