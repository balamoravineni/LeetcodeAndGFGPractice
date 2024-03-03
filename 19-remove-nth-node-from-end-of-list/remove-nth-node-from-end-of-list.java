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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // return twoPass(head,n);
        return onePass(head,n);
    }

    ListNode onePass(ListNode head, int n) {
        ListNode fast = head;
        while(n-->0) fast = fast.next;
        ListNode slow = head;
        ListNode prev = null;
        while(fast!=null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev==null) return head.next;
        prev.next = prev.next.next;
        return head;
    }

    ListNode twoPass(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while(curr!=null) {
            curr = curr.next;
            len++;
        }
        if(len==n) return head.next;
        curr = head;
        int i=1;
        while(i++<len-n) curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }
}