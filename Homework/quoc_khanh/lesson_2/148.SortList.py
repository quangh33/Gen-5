# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def findMiddleNode(head: Optional[ListNode]):
    if head is None or head.next is None:
        return head
    fast, slow, prevSlow = head, head, None
    while fast != None and fast.next != None:
        prevSlow = slow
        slow = slow.next
        fast = fast.next
        if fast:
            fast = fast.next
    return prevSlow, slow

def mergeTwoSortedLinkedList(list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    if list1 == None and list2 is None:
        return None
    if list1 == None:
        return list2
    if list2 == None:
        return list1
    pointer1, pointer2 = list1, list2
    
    dummyNode = ListNode()
    newTail = dummyNode
    next = None
    while pointer1 != None and pointer2 != None:
        if pointer1.val < pointer2.val:
            next = pointer1.next
            pointer1.next = None
            newTail.next = pointer1
            newTail = newTail.next
            pointer1 = next
        else:
            next = pointer2.next
            pointer2.next = None
            newTail.next = pointer2
            newTail = newTail.next
            pointer2 = next

    if pointer1 != None:
        newTail.next = pointer1
    if pointer2 != None:
        newTail.next = pointer2
    return dummyNode.next
             

class Solution:
    def sortList(self, node: Optional[ListNode]) -> Optional[ListNode]:
        if node == None or node.next == None:
            return node
        prevMiddle, middle = findMiddleNode(node)
        if prevMiddle:
            prevMiddle.next = None
        left = node
        list1 = self.sortList(left)
        list2 = self.sortList(middle)
        return mergeTwoSortedLinkedList(list1, list2)