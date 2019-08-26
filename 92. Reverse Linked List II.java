/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tail = null, before = null;
        ListNode curr = head, prev = null, next = null;
        int i = 1;
        while (i <= n) {
            if (i < m) {
                before = curr;
                prev = curr;
                curr = curr.next;
            } else {
                if (i == m) {
                    tail = curr;
                }
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            i++;
        }
        tail.next = curr;
        if (before != null) {
            before.next = prev;
            return head;
        } else {
            return prev;
        }
    }
}