/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode reverseList(ListNode head) {
        // return reverseListByLoop(head);
        return reverseListByRecursive(head, null);
    }
    
    private ListNode reverseListByLoop(ListNode head){
        ListNode preListNode= null;
        ListNode temp= null;
        while(true){
            temp = head.next;
            head.next = preListNode;
            preListNode = head;
            
            if(temp==null){
                break;
            }
            
            head = temp;
        }
        return head;
    }
    
    private ListNode reverseListByRecursive(ListNode head, ListNode preListNode){        
        ListNode temp= null;
        
        temp = head.next;
        head.next = preListNode;
        preListNode = head;
        
        if(temp==null){
            return head;
        }
        
        head = temp;
        return reverseListByRecursive(head, preListNode);
    }
    
}