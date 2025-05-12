// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// 160. Intersection of Two Linked Lists
// Difficulty: Easy

// Follow up: O(m+n) time, O(1) space

class Solution {

    /*
     * Intuition: As we are guaranteed node values are strictly
     * positive, swapping their signs marks them as seen in-place
     * while allowing recovery of the initial value, satisfying all
     * conditions of the problem.
     * 
     * Hence, we mark all nodes along A, and then traverse B, getting
     * the first negative node (or null if none) as the intersection.
     * We finally traverse A unmarking each node to return the DS to
     * its original state, and return the intersection.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // pass 1 - O(n): mark all nodes along A as negative
        ListNode currA = headA;
        while (currA != null) {
            currA.val = -currA.val;
            currA = currA.next;
        }

        // pass 2 - O(m): find intersection
        ListNode currB = headB;
        ListNode intersection = null;
        while (currB != null) {
            if (currB.val < 0) {
                intersection = currB;
                break;
            }
            currB = currB.next;
        }

        // pass 3 - O(n): cleanup
        currA = headA;
        while (currA != null) {
            currA.val = -currA.val;
            currA = currA.next;
        }

        // Total time:  O(n+m+n) = O(m+n)
        // Total space: O(1) (in place)
        return intersection;
    }
}