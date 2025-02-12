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

/**
 * Time complexity: O(n log k)
 * Space complexity: O(k)
 * Leetcode: Yes
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //base
        if(lists == null || lists.length == 0){
            return null;
        }

        //logic
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        for(ListNode list: lists){
            if(list != null) pq.add(list);
        }

        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}