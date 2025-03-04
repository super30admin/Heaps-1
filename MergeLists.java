// Time Complexity : O((n*k)logk) n- average size of each list k - no of lists
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Min Heaps
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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }

        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;

        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
