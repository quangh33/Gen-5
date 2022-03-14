package lession01;

/**
 * @author taivt
 * @link https://leetcode.com/problems/linked-list-cycle/
 * @since 2022/03/15 00:55:40
 */
public class TaiVo141LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(new Solution().hasCycle(node1));
    }

    private static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode singleStep = head;
            ListNode doubleStep = head;

            while (doubleStep != null && doubleStep.next != null) {
                singleStep = singleStep.next;
                doubleStep = doubleStep.next.next;
                if (doubleStep == singleStep) {
                    return true;
                }
            }

            return false;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
