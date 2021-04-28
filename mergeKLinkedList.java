// N : Total no of elements across all the lists
// K : No of lists
// Time Complexity : O(NlogK)
// Space Complexity : O(K) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode list:lists){
            if(list!=null) pq.add(list);
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            head.next = curr ;
            if(curr.next!=null) pq.add(curr.next);
            head = head.next;
        }
        return dummy.next;
    }
}
