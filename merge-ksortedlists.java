// Time Complexity : O(nlogk) where k is no.of linked lists and n is total no.of nodes in all lists
// Space Complexity : O(k) for priority queue space and if result is considered O(n) for result Linked List which stores all nodes
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
        ListNode result = new ListNode(-1, null);
        ListNode head = result;
        if(lists == null)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a ,b) -> a.val - b.val);
        for(ListNode temp: lists){
            if(temp != null)
                pq.add(temp);
        }
        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            result.next = n;
            result = result.next;
            if(n.next != null)
                pq.add(n.next);
        }
        return head.next;
    }
}

/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null)
            return null;
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li : lists)
            merged = merge(li, merged);
        return merged.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if(l2 != null)
            dummy.next = l2;
        if(l1 != null)
            dummy.next = l1;
        return result.next;
    }
}
*/
