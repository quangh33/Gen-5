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
 function recursion(head, prev) {
    if (head === null) return null
    if (head.next === null) {
        head.next = prev
        return head
    }
    
    const next = head.next
    head.next = prev
    return result = recursion(next, head)
}
var reverseList = function(head) {
    return recursion(head, null)
};