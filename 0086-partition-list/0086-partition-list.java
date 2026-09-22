class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes for the two partitions
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }

            curr = curr.next;
        }

        // End the greater/equal partition
        greater.next = null;

        // Connect the two partitions
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}
