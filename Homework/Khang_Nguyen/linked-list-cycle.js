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
    if (head === null) return false;
    let slow = head
    let fast = head

    while (true) {
      if (fast.visited) return true;
      fast.visited = true
      fast = fast.next
      if (fast === null) return false;
      if (fast.visited) return true;
      fast.visited = true
      fast = fast.next
      if (fast === null) return false;

      slow = slow.next
    } 
};