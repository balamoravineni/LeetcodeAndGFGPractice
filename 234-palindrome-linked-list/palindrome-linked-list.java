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
    public boolean isPalindrome(ListNode head) {
        // return usingExtraSpace(head);
        return optimised(head);
    }

    boolean optimised(ListNode head) {
        // reverse the second half & compare with first half
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = slow;
        if(fast!=null) secondHalf = slow.next;
        // reverse
        ListNode prev = null;
        while(secondHalf!=null) {
            ListNode next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }
        secondHalf = prev;
        // compare
        while(secondHalf!=null) {
            if(secondHalf.val!=head.val) return false;
            secondHalf = secondHalf.next;
            head = head.next;
        }
        return true;
    }

    boolean usingExtraSpace(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr!=null) {
            len++;
            curr = curr.next;
        }
        Map<Integer,Integer> indexMap = new HashMap<>();
        curr = head;
        int index = 0;
        while(index<len) {
            if(index<len/2) {
                indexMap.put(index, curr.val);
            }
            else if(len%2==1 && index==len/2) {
                //do nothing
            }
            else {
                if(indexMap.get(len-index-1)!=curr.val) return false;
            }
            curr = curr.next;
            index++;
        }
        return true;
    }
}