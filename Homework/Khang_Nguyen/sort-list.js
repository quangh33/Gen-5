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
var sortList = function (head) {
    if (head === null || head.next === null) return head;
    let fast
    let slow = fast = head

    while (fast.next !== null) {
        fast = fast.next
        if (fast.next === null) break;
        slow = slow.next
        fast = fast.next
    }
    const right = slow.next
    slow.next = null
    return merge(sortList(head), sortList(right))
};

var merge = function (list1, list2) {
    let cursor
    const result = cursor = { val: 0, next: null }
    while (list1 !== null && list2 !== null) {
        if (list1.val <= list2.val) {
            cursor.val = list1.val
            list1 = list1.next
        } else {
            cursor.val = list2.val
            list2 = list2.next
        }
        cursor.next = {}
        cursor = cursor.next
    }
    let prevNode;
    let leftOverList = list1
    if (list2 !== null) {
        leftOverList = list2
    }
    while (leftOverList !== null) {
        cursor.val = leftOverList.val
        cursor.next = {}
        prevNode = cursor
        cursor = cursor.next
        leftOverList = leftOverList.next
    }
    prevNode.next = null
    return result;
};
