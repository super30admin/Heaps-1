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
 //Time Complexity: O(Nlogk)
//Space Complexity: O(n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode i:lists){
            if(i!=null){
            pq.add(i);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!pq.isEmpty()){
            ListNode val = pq.poll();
            curr.next = val;
            curr = curr.next;
            if(val.next!=null){
                pq.add(val.next);
            }
        }
        return dummy.next;
    }
}