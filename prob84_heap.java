// S30 Big N Problem #84 {Hard}
// 23. Merge k Sorted Lists
// Time Complexity :O(k*log n) where k is the average length of linked list and n is the number of linked lists
// Space Complexity :O(n) where n is the number of linked lists
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //edge case
        if(lists ==null || lists.length==0) return null;
        ListNode dummy=new ListNode();
        ListNode result=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val); //Min Heap
        for(ListNode head:lists){
            if(head!=null) pq.add(head);
        }
        
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            dummy.next=min;
            dummy=dummy.next;
            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return result.next;
        
    }
}