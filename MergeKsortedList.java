
// Time Complexity = O(nklogk)
// Space Complexity = O(nk)


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
    public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue <ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node:lists){
            if(node != null){
                pq.add(node);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;

    }
}