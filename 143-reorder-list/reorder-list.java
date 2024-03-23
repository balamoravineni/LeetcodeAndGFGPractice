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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode secondHalf = slow;
        if(prev!=null) prev.next = null;
        // reverse
        prev = null;
        while(secondHalf!=null) {
            ListNode next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }
        secondHalf = prev;
        ListNode firstHalf = head;
        // System.out.println()
        // while(firstHalf!=null) {
        //     System.out.print(firstHalf.val + " ");
        //     firstHalf = firstHalf.next;
        // }
        // System.out.println();
        // while(secondHalf!=null) {
        //     System.out.print(secondHalf.val + " ");
        //     secondHalf = secondHalf.next;
        // }
        // firstHalf = head;
        // secondHalf = prev;


        // now alternating the nodes
        while(firstHalf!=secondHalf && secondHalf!=null && firstHalf!=null) {
            ListNode secondHalfNext = secondHalf.next;
            ListNode firstHalfNext = firstHalf.next;
            firstHalf.next = secondHalf;
            if(firstHalfNext!=null) secondHalf.next = firstHalfNext;
            firstHalf = firstHalfNext;
            secondHalf = secondHalfNext;
        }
        return;
    }
}