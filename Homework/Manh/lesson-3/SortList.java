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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        //Find middle and break the linked list to 2 parts
        ListNode middleNode = middleNode(head);
        ListNode rightHead = middleNode.next;
        middleNode.next = null;
        
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(rightHead);
        
        return merge(leftNode, rightNode);
    }
    
    private ListNode merge(ListNode leftNode, ListNode rightNode) {
		ListNode temp;
		if (leftNode == null)
			return rightNode;
		if (rightNode == null)
			return leftNode;
		if (leftNode.val > rightNode.val) {
			temp = leftNode;
			leftNode = rightNode;
			rightNode = temp;
		}

		ListNode cursor = leftNode;
		ListNode breakPoint = rightNode;
		temp = rightNode;
		while (cursor != null) {
			if (cursor.val <= rightNode.val && (cursor.next == null || rightNode.val <= cursor.next.val)) {
				if (cursor.next == null) {
					cursor.next = rightNode;
					break;
				} else {
					while (rightNode.next != null && rightNode.next.val <= cursor.next.val) {
						breakPoint = rightNode;
						rightNode = rightNode.next;
					}
					rightNode = breakPoint.next;

					breakPoint.next = cursor.next;
					cursor.next = temp;

					return merge(leftNode, rightNode);
				}
			} else {
				cursor = cursor.next;
				continue;
			}
		}
		return leftNode;
	}
    
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null) {
            fast = fast.next;
            if(fast.next == null) break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}











