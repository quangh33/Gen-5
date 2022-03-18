#https://leetcode.com/problems/linked-list-cycle/
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        p1 = head
        p2 = head
        while p2 is not None and p2.next is not None:
            p2 = p2.next.next
            p1 = p1.next
            if p1 == p2:
                return True
        return False