
// Time Complexity :O(nklogn)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : not sure about the space complexity


// Your code here along with comments explaining your approach
// using min heap -- > smallest element will be at head of pq
// 1. we will put first node of every list in priorityQueue
// 2. now until pq is not empty pop min from queue assigned it as next of result(curr) list and move curr a step ahead  if minmode has connected node (i.e min .next != null) then push min.next into the queue.
// 2. return the result(dummy) list

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
      
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        ListNode dummy = new ListNode(-1);
         ListNode curr = dummy;
        for(ListNode list : lists)
        {
            if(list != null)
            pq.add(list);
        }
     
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
                 pq.add(min.next);
         
        }
       return dummy.next;
    }
}