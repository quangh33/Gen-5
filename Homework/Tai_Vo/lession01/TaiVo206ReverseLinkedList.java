package lession01;

/**
 * @author taivt
 * @link https://leetcode.com/problems/reverse-linked-list/
 * @since 2022/03/17 22:23:33
 */
public class TaiVo206ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.print();

        ListNode head = new Solution().recursiveReverseList(node1);
        head.print();
    }

    // Space Complexity: O(1)
    // Time Complexity: O(n)
    private static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }

        public ListNode recursiveReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = recursiveReverseList(head.next);
            head.next.next = head;
            head.next = null;

            return newHead;
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

        void print() {
            ListNode iterator = this;
            while (iterator != null) {
                System.out.printf("%d ", iterator.val);
                iterator = iterator.next;
            }
            System.out.println();
        }
    }
}
