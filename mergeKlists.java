//time complexity O(nk logk)
//space complexity O(k)

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
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        //each list is represented by its head
        for(ListNode head: lists){
            if(head != null) pq.add(head);

        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null) pq.add(min.next);
        }
        return result.next;
    }
}
