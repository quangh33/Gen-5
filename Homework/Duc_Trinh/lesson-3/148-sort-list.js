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

function getParts(head) {
    let slowPointer = head
    let fastPointer = head.next
    while (fastPointer && fastPointer.next) {
        slowPointer = slowPointer.next
        fastPointer = fastPointer.next.next
    }
    const rightHead = slowPointer.next
    slowPointer.next = null
    return [head, rightHead]
}
function merge(left, right) {
    if (!left.next && !right.next) {
        if (left.val < right.val) {
            left.next = right    
            return left
        } else {
            right.next = left    
            return right
        }
    } else {
        let writeHead = new ListNode(-Infinity, null)
        let readPointerLeft = left
        let readPointerRight = right
        let curr = writeHead
        while (readPointerLeft || readPointerRight) {
            if (!readPointerRight || (readPointerLeft && readPointerLeft.val <= readPointerRight.val)) {
                curr.next = readPointerLeft
                readPointerLeft = readPointerLeft.next
            } else {
                curr.next = readPointerRight
                readPointerRight = readPointerRight.next
            }
            curr = curr.next
        }
        return writeHead.next
    }
}
var sortList = function(head) {    
    if (!head || !head.next) return head
    const [left, right] = getParts(head)
    const leftSorted = sortList(left)
    const rightSorted = sortList(right)
    return merge(leftSorted, rightSorted)
};