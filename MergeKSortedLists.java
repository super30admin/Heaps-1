// Time Complexity : O(nk logk). n is the average number of elements of a linked list. k is the number of element in heap
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
     
        if(lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node!=null) pq.add(node);
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode resultNode = dummyNode;
        
        while(!pq.isEmpty()){
            
            ListNode minNode = pq.poll();
            dummyNode.next=minNode;
            dummyNode = dummyNode.next;
            
            if(minNode.next!=null){
                minNode = minNode.next;
                pq.add(minNode);
            }
            
        }
        return resultNode.next;
        
    }
}
