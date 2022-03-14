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
    
    # def reverseList_recursive(self, head: Optional[ListNode], tail=None) -> Optional[ListNode]:
    #     next_node = head.next
    #     head.next=tail
    #     if next_node is None:
    #         return head
    #     else:
    #         reverseList_recursive(next_node,head)