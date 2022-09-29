import java.util.PriorityQueue;

/*
## Problem2:
Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

Time Complexity :   O (N log(nk)) 
Space Complexity :  O (nk) 
Did this code successfully run on Leetcode :    Yes (23. Merge k Sorted Lists)
Any problem you faced while coding this :       No

 */
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]

class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            } 
        }
            
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;

            // move min Listnode pointer to next
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}