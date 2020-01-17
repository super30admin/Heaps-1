//Time Complexity: O(Nlog K)
// Space Complexity: O(logk)


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((ListNode a, ListNode b) -> (a.val - b.val));
        for(ListNode headNode: lists){
            if(headNode != null) pq.add(headNode);
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
} 