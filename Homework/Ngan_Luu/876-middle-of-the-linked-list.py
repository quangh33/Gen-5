#https://leetcode.com/problems/middle-of-the-linked-list
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        p1 = head
        p2 = head
        while p2:
            if p2.next is None:
                return p1
            elif p2.next.next is None:
                return p1.next
            else:
                p2 = p2.next.next
                p1 = p1.next