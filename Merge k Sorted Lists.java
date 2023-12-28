// Time Complexity :O(nlogk)
// Space Complexity :O(k) //size of the heap
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        for(ListNode node: lists)
        {
          if(node!=null)
            pq.add(node);
        }

        while(!pq.isEmpty())
        {
           ListNode temp=pq.poll();
            if(temp.next!=null)
            pq.add(temp.next);

            result.next=temp;
            result= result.next;
        }

        return dummy.next;

    }
}