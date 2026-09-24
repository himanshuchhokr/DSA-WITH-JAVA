class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // No need to reverse
        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles the case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node just before 'left'
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // curr is the first node that needs to be reversed
        ListNode curr = prev.next;

        // Reverse nodes from left to right
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;

            // Remove next from its current position
            curr.next = next.next;

            // Insert next immediately after prev
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
