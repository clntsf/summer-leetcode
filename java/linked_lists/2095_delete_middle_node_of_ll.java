class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        // special case: size 1
        if (head.next == null) return null;
 
        // special case: size 2
        if (head.next.next == null) {
            head.next = null;
            return head;
        }

        // walk-run through the list to get middle node
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        // special cases make this way easier
        // easy-delete: value swap with next node
        walker.val = walker.next.val;
        walker.next = walker.next.next;

        return head;
        
    }
}