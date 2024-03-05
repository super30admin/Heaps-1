// Time Complexity :O(nlog k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
    
}