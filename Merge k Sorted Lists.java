// Time Complexity : O(nk log(k)) n = length of lists k = # of lists
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
        //edge 
        if(lists == null) return null;
        //create a pq as max heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        //dummy list node
        ListNode dummy = new ListNode(-1);
        //return node
        ListNode res = dummy;
        //iterate over the heads of the nodes because they are the smallest ones in each sorted list
        for(ListNode h : lists){
            //add to the pq if head isn't null
            if(h != null){
                pq.add(h);  
            }
        }
        //process all the nodes in the pq 
        while(!pq.isEmpty()){
            //the top is the min so take that out
            ListNode min = pq.poll();
            //set the dummy.next to be the min
            dummy.next = min;
            //move the dummy to the next pointer
            dummy = dummy.next;
            //if the end of the of one the list node's we are moving over isn't null add it to the pq
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return res.next;
    }
}