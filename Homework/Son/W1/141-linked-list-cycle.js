/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
 var hasCycle = function(head) {
    if (head === null) return false
    let slow = head;
    let fast = head;
    while (fast !== null) {
        if (fast.next !== null)  {
            fast = fast.next; slow = slow.next;
        } else return false;
        if (fast.next !== null) {fast = fast.next} 
        else return false;
        if (fast == slow) return true
    }
};

// https://leetcode.com/problems/linked-list-cycle/