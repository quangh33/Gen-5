package lession01;

/**
 * @author taivt
 * @link https://leetcode.com/problems/middle-of-the-linked-list/
 * @since 2022/03/15 00:35:05
 */
public class TaiVo876MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println("The given linked list: ");
        ListNode head = node1;
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();

        ListNode middleNode = new Solution().middleNode(node1);
        System.out.println("The middle node of the given linked list is: " + middleNode.val);
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode singleStep = head;
            ListNode doubleStep = head;

            while (doubleStep != null && doubleStep.next != null) {
                singleStep = singleStep.next;
                doubleStep = doubleStep.next.next;
            }

            return singleStep;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
