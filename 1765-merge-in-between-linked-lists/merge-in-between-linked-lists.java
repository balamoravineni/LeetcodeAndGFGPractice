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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1;
        ListNode aPrev = null;
        ListNode bNext = null;
        int index = 0;
        while(curr!=null) {
            if(index==a-1) aPrev = curr;
            if(index==b) bNext = curr.next;
            curr = curr.next;
            index++;
        }
        aPrev.next = list2;
        curr = list2;
        while(curr.next!=null) curr = curr.next;
        curr.next = bNext;

        return list1;
    }
}