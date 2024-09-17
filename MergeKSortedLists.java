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
// Time Complexity: O(nkogk)
// Space COmplexity: O(n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for(ListNode l1: lists) {
            if(l1!=null) {
                pq.add(l1);
            }
        }

        ListNode head = new ListNode();
        ListNode temp = head;
        while(!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
            ListNode next = temp.next;
            if(next != null) {
                pq.add(next);
            }
        }
        return head.next;
    }
}