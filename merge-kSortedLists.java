// Time Complexity : O(nk log(k) )
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Best approach: 
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
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode node: lists){
            if(node != null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}

// ***************************************
// Time Complexity : O(nk log(nk) )
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Brute Force:
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
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li: lists){
            merged = merge(merged, li);
        }
        return merged.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            }
            else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(p1 != null){
            curr.next = p1;
            p1 = p1.next;
        }
        if(p2 != null){
            curr.next = p2;
            p2 = p2.next;
        }
        return dummy.next;
    }
}