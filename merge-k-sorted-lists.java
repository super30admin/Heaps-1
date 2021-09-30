//Time complexity: O(Nlogk)
//Space complexity: O(N)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        //add first node of each list to the heap
        for(ListNode node: lists) {
            if(node != null) {
                pq.add(node);
            }
        }
        //while heap is not empty
        while(!pq.isEmpty()) {
            //poll the minimum 
            ListNode min = pq.poll();s
            curr.next = min;
            curr = curr.next;
            if(min.next != null) {
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}