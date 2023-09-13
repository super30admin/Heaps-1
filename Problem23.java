// Time Complexity : O(nk* log k) --> min heap on k lists each can have average of n nodes
// Space Complexity : o(k)  --> min heap stores k list heads at any point of time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>  minHeap = new  PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode head : lists){
            if(head!=null){
              minHeap.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!minHeap.isEmpty())
        {
            ListNode min = minHeap.poll();
            curr.next = min;
            curr= curr.next;
            if(min.next!=null){
                minHeap.add(min.next); //new node added in minheap
            }
        }
        return dummy.next;
    }
}