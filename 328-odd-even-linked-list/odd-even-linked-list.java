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
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode currEven = head.next;
        while(currEven!=null && currEven.next!=null){
            ListNode nextOdd = currEven.next;
            ListNode nextEven = null;

            oddTail.next = nextOdd;
            nextEven = nextOdd.next;
            nextOdd.next = evenHead;
            oddTail = nextOdd;

            currEven.next = nextEven;
            currEven = nextEven;
        }
        return head;
    }
}