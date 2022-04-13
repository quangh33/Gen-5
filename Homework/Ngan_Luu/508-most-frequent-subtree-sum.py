# 508. https://leetcode.com/problems/most-frequent-subtree-sum/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        freq={}
        def dfs(node):
            if not(node):
                return 0
            else:
                left_val=dfs(node.left)
                right_val=dfs(node.right)
                sum_node=left_val+right_val+node.val
                if sum_node in freq:
                    freq[sum_node]+=[node.val]
                else:
                    freq[sum_node]=[node.val]
                return sum_node
        dfs(root)
        max_freq=0
        for key,value in freq.items():
            if len(value)>max_freq:
                output=[key]
                max_freq=len(value)
            elif len(value)==max_freq:
                output.append(key)
        return output