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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<>();
        boolean deleted = true;
        ListNode curr = head;
        while (deleted) {
            deleted = false;
            int sum = 0;
            while(curr!=null) {
                sum += curr.val;
                if(sum==0) {
                    head = curr.next;
                    map.clear();
                    deleted = true;
                }
                else if(map.containsKey(sum)) {
                    map.get(sum).next = curr.next;
                    deleted = true;
                }
                else {
                    map.put(sum, curr);
                }
                curr = curr.next;
            }
            map.clear();
            curr = head;
        }
        return head;
    }
}