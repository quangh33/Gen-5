/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

function middleNode(head) {
  let slow = head;
  let fast = head;
  while (slow.next && fast.next && fast.next.next) {
    slow = slow.next;
    fast = fast.next.next;
  }
  return slow;
}

function mergeLists(head1, head2) {
  let cur1 = head1;
  let cur2 = head2;
  let headResult = null;
  let curResult = null;
  while (cur1 && cur2) {
    let next;
    if (cur1.val < cur2.val) {
      next = cur1;
      cur1 = cur1.next;
    } else {
      next = cur2;
      cur2 = cur2.next;
    }
    if (curResult) {
      curResult.next = next;
    }
    curResult = next;

    if (!headResult) {
      headResult = curResult;
    }
  }
  if (cur1) {
    curResult.next = cur1;
  }
  if (cur2) {
    curResult.next = cur2;
  }
  return headResult;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function (head) {
  if (!head || !head.next) {
    return head;
  }
  // split list in halves
  let middle = middleNode(head);
  let rightHead = middle.next;
  middle.next = null;

  head = sortList(head);
  rightHead = sortList(rightHead);

  return mergeLists(head, rightHead);
};
