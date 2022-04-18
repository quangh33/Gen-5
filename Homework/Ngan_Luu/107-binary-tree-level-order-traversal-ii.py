# 107. https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue=[]
        if root:
            queue=[root]
        levelOfTree=[0]
        ans=[]
        while queue:
            node=queue[0]
            level=levelOfTree[0]
            if level >= len(ans):
                ans.append([node.val])
            else:
                ans[level].append(node.val)
            queue.pop(0)
            levelOfTree.pop(0)
            if node.left:
                queue.append(node.left)
                levelOfTree.append(level+1)
            if node.right:
                queue.append(node.right)
                levelOfTree.append(level+1)
        return ans[::-1]