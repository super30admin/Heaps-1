//Time: O(nklogn)
//Space: O(k)
//https://leetcode.com/submissions/detail/628981539/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head: lists) {
            if(head != null) {
                pq.add(head);
            }
        }
            ListNode dummy =new ListNode(-1);
            ListNode curr = dummy;
            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                curr.next = min;
                curr = curr.next;
                //put the next node of min node in heap
                if(min.next != null)
                    pq.add(min.next);     
            }
        return dummy.next;
    }
}