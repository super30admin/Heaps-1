// Time Complexity : O(N*L) where N is the number of heads and L is the length of the list
// Space Complexity : O(N) N = number of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
	1. Add all the heads in the minHeap
	2. Remove the smallest one and add to our final result LL
	3. Add the next element of the recently removed node.
	4. Return our custom LL containing the elements in increasing order
*/


// Your code here along with comments explaining your approach
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        
        for(ListNode list: lists) {
            if(list!=null)
                minHeap.add(list);
        }
        
        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null) minHeap.add(min.next);
        }
        return temp.next;
        
    }
}
