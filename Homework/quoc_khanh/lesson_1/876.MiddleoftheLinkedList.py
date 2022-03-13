from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = head
        slow = head
        while fast != None:
            if fast.next != None:
                slow = slow.next
                fast = fast.next.next
            else:
                fast = fast.next
        return slow