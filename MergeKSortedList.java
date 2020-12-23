/**
 * SC : O(n) TC : O(mn) m-> total lists n-> nodes in each least
 * Approach : create a min heap and add all the heads Nodes from the list of Nodes to be sorted. And iterate for the minimum's next node
 *            putting  the curr node in the result list.
 */
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
        // if(lists == null) return new ListNode();
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode l: lists){
          if(l != null)  pq.add(l);
        } 
        while(!pq.isEmpty()){
            // int size = pq.size();
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next!= null) pq.add(curr.next);
        }
        return dummy.next;
    }
}