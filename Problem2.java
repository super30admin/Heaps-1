// Time Complexity :O(nx2^n)
// Space Complexity : O(nx2^n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in with min stack. First add all the heads of the lists and maintain the min heap.

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head:lists){
            if(head != null){
            pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr=curr.next;
            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}