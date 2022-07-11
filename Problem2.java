// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//23. Merge k Sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/


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


class Problem2 {
    //time:O(nlogk)
    //space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists){
            if(head != null)
                pq.add(head);
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


/*
My code
class Solution {
    //time:O(nlogk)
    //space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = null;
        if (lists.length == 0 || lists == null) return dummy;
        dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode l: lists){
            //how to add to the queue
            if(l != null){
                pq.add(l);
                //System.out.println(l.val);
            }
            
        }
       ListNode pointer = dummy;
        
        while(!pq.isEmpty()){
            
         
             ListNode temp = pq.poll();
             ListNode t = temp.next;
             temp.next = pointer.next;
             pointer.next = temp;
             pointer = temp;
                
                if(t != null) pq.add(t);
                else if(t == null && !pq.isEmpty()){
                    while(!pq.isEmpty() && pq.peek().next == null){
                        ListNode temp2 = pq.poll();
                        ListNode t2 = temp2.next;
                        temp2.next = pointer.next;
                        pointer.next = temp2;
                        pointer = temp2;
                    }
                    
                }
     }
        
        while(!pq.isEmpty()){
             ListNode temp = pq.poll();
             temp.next = pointer.next;
             pointer.next = temp;
             pointer = temp;
        }
        
        dummy = dummy.next;
        return dummy;
    }
}
*/
