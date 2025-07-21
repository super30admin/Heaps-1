// Problem2
// Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)


// Time Complexity : O(n*k(log(k)))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// isering each head to the min heap, whichever is least poll it and add it to the result list,
// and push its next node to the min heap. keep doing it until pq is not empty

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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode result = new ListNode(-1);
        ListNode temp= result;
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode currentNode = pq.poll();
            temp.next=currentNode;
            temp=temp.next;
            if(currentNode.next!=null) pq.add(currentNode.next);
        }
        return result.next;
    }
}