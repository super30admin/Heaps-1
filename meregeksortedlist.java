// Time Complexity : o(nk) n list k elments in list 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val); // will put listnode as traverse it
        
        ListNode dummy = new ListNode(-1);
        ListNode curr=dummy;
        
        for(ListNode ln:lists){
            if(ln!=null){
                pq.add(ln);
            }
        }
        
        while(!pq.isEmpty()){
            ListNode min= pq.poll();    // min will be removed from pq
            curr.next=min;
            if(min.next!=null){
                pq.add(min.next);
            }
            curr=curr.next;
        }
        
        return dummy.next;
    }
}