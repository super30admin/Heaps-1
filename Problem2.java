/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode start = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val); // maxHeap to keep track of minimum elements

        for (ListNode list : lists) {
            if (list != null)
                pq.offer(list);
        }
        
        while (pq.size()>0) {
            ListNode curr = pq.poll();
            start.next = new ListNode(curr.val);
            start = start.next;
            if (curr.next!=null)
                pq.offer(curr.next);
        }
        return head.next;
    }
}
