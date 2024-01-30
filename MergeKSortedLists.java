// Time Complexity :nk log nk
// Space Complexity :O(nk)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: use min Heap

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode current= dummy;
        while(!pq.isEmpty()){
            ListNode minCurrent= pq.poll();
            current.next= minCurrent;
            current=current.next;

            if(minCurrent.next!=null){
                pq.add(minCurrent.next);
            }
        }
        return dummy.next;
    }
}