// TC: O(n x mlog(n x n))
// SC: O(m x n)
// m is number of lists, n is max number of nodes in lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for(ListNode head : lists) {
            if(head != null) {
                pq.add(head);
            }
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}