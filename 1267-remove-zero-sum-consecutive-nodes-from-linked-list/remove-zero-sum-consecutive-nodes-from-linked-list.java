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
        int sum = 0;
        ListNode curr = head;
        while(curr!=null) {
            sum += curr.val;
            if(sum==0) {
                head = curr.next;
                // remove all nodes from beginning till here
                map.clear();
            }
            else if(map.containsKey(sum)) {
                // remove all nodes from above currentSum
                ListNode temp = map.get(sum).next;
                int tempSum = sum;
                while(temp!=curr) {
                    tempSum += temp.val;
                    map.remove(tempSum);
                    temp = temp.next;
                }
                map.get(sum).next = curr.next;
            }
            else {
                map.put(sum, curr);
            }
            curr = curr.next;
        }
        return head;
    }
}