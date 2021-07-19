// Time Complexity : O(nk log k)
// Space Complexity : O(k)

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
        ListNode head = new ListNode(-1); 
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for(ListNode list: lists){
            if(list != null)
                pq.add(list);
        }
        ListNode cur = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null)
                pq.add(node.next);
            cur.next = node;
            cur =  cur.next;
        }
        return head.next;
    }
}