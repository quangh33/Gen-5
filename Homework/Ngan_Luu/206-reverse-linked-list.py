#https://leetcode.com/problems/reverse-linked-list/ ( 2 ways, iterative & recursive)
class Solution:
    def reverseList_iterative(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None                 
        curr = head
        while curr:
            next_node = curr.next               
            curr.next = prev       
            prev = curr            
            curr = next_node        
        return prev
    
    def reverseList_recursive(self, head: Optional[ListNode], tail=None) -> Optional[ListNode]:
        if head is None:
            return tail
        next_node=head.next
        head.next=tail
        tail=head
        head=next_node
        return self.reverseList_recursive(head,tail)
