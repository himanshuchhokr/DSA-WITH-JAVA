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
    public ListNode insertionSortList(ListNode head) {

        // Create a dummy node
        ListNode dummy = new ListNode(0);

        // Traverse the original linked list
        ListNode curr = head;

        while (curr != null) {

            // Save the next node
            ListNode next = curr.next;

            // Find the correct position
            ListNode prev = dummy;

            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }

            // Insert current node at the correct position
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node
            curr = next;
        }

        return dummy.next;
    }
}
