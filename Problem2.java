/*
Merge k Sorted Lists(https://leetcode.com/problems/merge-k-sorted-lists/)

Time Complexity : O(nklogk)
Space Complexity : O(k)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = new ListNode(-1);
        ListNode result = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists){
            if(list != null){                
                pq.add(list);
            }
        }

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            head.next = curr;
            head = head.next;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }


        return result.next;


    }
}