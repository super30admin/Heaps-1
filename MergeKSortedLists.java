// Time Complexity : O(NLogK)
// Space Complexity : O(K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (!pq.isEmpty()) {//N
            ListNode minNode = pq.poll(); //logk
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.add(minNode.next); //logk
            }
        }
        curr.next = null;
        return dummyNode.next;
    }
}