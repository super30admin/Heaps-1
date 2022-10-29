// Time Complexity : O(nk log k) k is number of linkedLists with n avg elemnts
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
        for(ListNode listNode : lists) {
            if(listNode != null)
                pq.add(listNode);
        }
        ListNode merged = new ListNode(-1);
        ListNode dummy = merged;
        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            dummy.next = curr;
            if(curr.next != null){
                pq.add(curr.next);
            }
            dummy = dummy.next;
        }

        return merged.next;
    }
}