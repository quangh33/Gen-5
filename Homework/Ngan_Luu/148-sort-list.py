https://leetcode.com/problems/sort-list/ (implement merge sort)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self,head):
        slow = head
        fast = head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow
        
    def merge(self,left,right):
        sorted_list=temp=ListNode()
        while left and right:
            if left.val < right.val:
                sorted_list.next=left
                left=left.next
            else:
                sorted_list.next=right
                right=right.next
            sorted_list=sorted_list.next
        if left:
            sorted_list.next=left
        if right:
            sorted_list.next=right
        return temp.next

    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        left=head
        middle_node=self.middleNode(head)
        right=middle_node.next
        middle_node.next=None
        
        left=self.sortList(left)
        right=self.sortList(right)
        return self.merge(left,right)