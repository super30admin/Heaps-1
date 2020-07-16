// Time Complexity :O(nk Log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * another approach - nk^2 solution - merge two list at a time.
 * 
 * using heap - nklogk solution - maintain min heap of size k and take out one element at a time
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists
 * 
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
        
        //use min heap of ListNodes
        Queue<ListNode> pQ = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        
        //add non null heads of all list into min heap O(k)
        for(ListNode node: lists){
            if(node != null) {
               pQ.add(node); //log k 
            }   
        }
        
        ListNode dummy = new ListNode(-1);
        
        ListNode curr = dummy;
        
        while(!pQ.isEmpty()){ //O(nk)
            curr.next = pQ.poll();
            curr = curr.next;
            
            //O(log(k))
            if(curr.next != null){
                pQ.add(curr.next);
            }
        }
        
        return dummy.next;
    }
}