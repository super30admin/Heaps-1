//Time complexity=O(Nk log K)
//Space complexity=O(Nk)
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
        ListNode dummy=new ListNode(-1);
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->(a.val-b.val));
        //Initially we are adding all the head to our priority queue 
        for(ListNode head:lists)
        {    if(head!=null)
            {
                pq.add(head);
            }
        }
        
        //We are maintaining a result node that points to the dummy node, and we are adding the elements to our dummy node, and atlast we are returning our result node
        ListNode result=dummy;
        
        //we are removing the top element of the queue and adding it to our dummy node, here we are using min heap so the top most element is minimun in the queue
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();
            dummy.next=min;
            if(min.next!=null)
                pq.add(min.next);
            dummy=dummy.next;
        }
        return result.next;
    }
}