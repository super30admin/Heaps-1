/* Time Complexity : O((n^2)k)
 *	n - avg len of the lists - nums
 * 	k - number of lists */
/* Space Complexity : O(1) */
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
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li: lists){
            if(li != null){
                merged = merge(merged, li);
            }
        }
        return merged.next;
    }

	//By maintatining two pointers on two sorted list merge them and merge the resultant with the thrid list and so on...
    private ListNode merge(ListNode li, ListNode l2){
        ListNode p1 = li;
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
        }
        if(p2 != null){
            curr.next = p2;
        }
        return dummy.next;
    }
}