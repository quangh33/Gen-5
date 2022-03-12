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
var reverseList = function (head) {
  let prev = null;
  let cur = head;
  while (cur) {
    let next = cur.next;
    cur.next = prev;

    prev = cur;
    cur = next;
  }
  return prev;
};

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseListRecur = function (head) {
  if (!head) return head;
  if (!head.next) return head;
  let result = reverseListRecur(head.next);
  head.next.next = head;
  head.next = null;
  return result;
};
