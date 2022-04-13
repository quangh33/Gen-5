# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseInRecursion(self, prev: ListNode, curr: ListNode) -> ListNode:
        if curr == None:
            return prev
        next = curr.next
        curr.next = prev
        return self.reverseInRecursion(curr, next)
    
    def reverse(self, head: ListNode) -> ListNode:
        if head.next == None:
            return head
        newHead = head
        currNode = head.next
        head.next = None
        while currNode != None:
            nextNode = currNode.next
            currNode.next = newHead
            newHead = currNode
            currNode = nextNode
        return newHead

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None:
            return None
        # return self.reverseInRecursiov(None, head)
        return self.reverse(head)