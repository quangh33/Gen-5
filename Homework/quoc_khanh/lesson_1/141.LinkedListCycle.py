from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return False
        slow, fast = head, head
        while fast != None:
            slow = slow.next
            # first step
            fast = fast.next
            if fast == None:
                return False
            # second step
            fast = fast.next
            if fast == slow:
                return True
        return False
