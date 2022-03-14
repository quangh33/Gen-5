/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 var middleNode = function(head) {
    if(!head || !head.next) return head;
    let slow = head;
    let fast = head;
    while(fast !== null){  
        if (fast.next) fast = fast.next
        else return slow;
        if (fast.next) fast = fast.next
        else return slow.next;
        slow = slow.next;
    }
};
// https://leetcode.com/problems/middle-of-the-linked-list/