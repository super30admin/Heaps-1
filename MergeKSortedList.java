//https://leetcode.com/problems/merge-k-sorted-lists/
// Time Complexity :O(nk logk)  
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


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
        //insert all the heads in the pq
        for(ListNode head:lists){
            if(head!=null)
                pq.add(head);
        }
        ListNode result=new ListNode(-1); //final output merged array
        ListNode curr=result; //to move in the result linked list
        while(!pq.isEmpty())
        {
            ListNode min=pq.poll();//whatever is in the top is the min value; remove it
            curr.next=min;
            curr=curr.next; //moved the pointer in the result array
            if(min.next!=null) //when the list with min value is not empty add its next element for further processing
            {
                pq.add(min.next);      
            }
        }
        return result.next; //as result first node is a dummy node
        
    }
}