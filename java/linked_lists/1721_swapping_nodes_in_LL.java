class Solution {
    /*
     * We use the same walker-runner technique as in
     * #19, but keep a pointer to the kth node (which
     * we reach at the end of loop 1) to swap with the
     * kth-last node which we traverse to the normal way.
     * 
     * Slight changes are made to the loop conditions as
     * we want the kth-last node, not the previous node (as
     * we would if we wanted to delete the kth-last)
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = null;

        // find kth node
        for (int i=1; i<k; i++) fast = fast.next;
        first = fast;

        // find kth-last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // swap values
        int tmp = first.val;
        first.val = slow.val;
        slow.val = tmp;
        return head;
    }
}