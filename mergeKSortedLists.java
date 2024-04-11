// Time Complexity : O(n log k)
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
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li : lists){
            if(li != null){
                merged = merge(li,merged);
            }
        }
        return merged.next;
    }

    private ListNode merge(ListNode n1, ListNode n2){
        ListNode p1 = n1;
        ListNode p2 = n2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1= p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr= curr.next;
        }
        if(p1 != null){
            curr.next = p1;
        }
        if(p2 != null){
            curr.next = p2;
        }
        return dummy.next;
    }
}