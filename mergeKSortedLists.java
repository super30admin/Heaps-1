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
//Time complexity O(nlog(n))
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val) - (b.val));
        
        ListNode dummy = new ListNode(-1);
        
        for(int i = 0; i < lists.length; i ++){
            
            if(lists[i] != null){
                
                 pq.add(lists[i]);
            }
           
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            
            ListNode min = pq.poll();
            
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                
               pq.add(min.next); 
            }
            
            
            
        }
        
        return dummy.next;
    }
}