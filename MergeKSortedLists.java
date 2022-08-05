// Time Complexity : O(NKlog(K))
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

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
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode head = pq.poll();
            cur.next = head;
            if(head.next!=null){
                pq.add(head.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}