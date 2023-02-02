// Time Complexity : O(nk logk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We store the first node of all linked lists in a priority queue
// We then remove min to form the linkedlist. Eeach time we remove min node, we add its next node
// Repeat till priority queue is empty

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for(ListNode l:lists){
            if(l!=null)
                pq.add(l);
        }
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            if(temp.next!=null) pq.add(temp.next);
            curr.next = temp;
            curr = curr.next;
        }
        return result.next;
    }
}