// TC:O(Nlogk)
// SC:O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));
        ListNode root = new ListNode(0);
        ListNode head = root;
        for(int i=0 ; i<lists.length ; i++) {
            ListNode node = lists[i];
            if(node != null) pq.add(node);
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if(node.next != null) pq.add(node.next);
        }
        return root.next;
    }
}