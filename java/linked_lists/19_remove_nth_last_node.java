// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description
// 19. Remove Nth Node From End of List
// Difficulty: Medium

class Solution {
    /*
     * Here we use a walker-runner technique: if we move a
     * runner node up n steps, and then move both the walker
     * and the runner until the runner hits the end, the walker
     * will be at the kth-last node, which we can delete
     * 
     * We handle one edge case where the runner hits the end after
     * the first loop, meaning we have to remove the head.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // move the runner up n steps
        for (int i=0; i<n; i++) fast = fast.next;

        // edge case: remove first node
        if (fast == null) return head.next;

        // move both nodes until the runner hits the end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // node removal (slow is the node before the kth-last)
        slow.next = slow.next.next;
        return head;
    }
}