Time Complexity: o(nk log k)
Space Complexity: o(k)
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
        int len = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node: lists)
        {
            if(node != null) q.add(node);
        }
        while(!q.isEmpty())
        {
            ListNode node = q.poll();
            dummy.next = node;
            dummy = dummy.next;
            if(node.next != null) q.add(node.next);
        }
        return res.next;
    }
}