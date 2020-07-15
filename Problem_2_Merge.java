// Time complexity - O(nk^2), n = number of lists, k = avg length of lists
// Space complexity - O(1)

// Merge lists iteratively

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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode result = dummy;
        for(ListNode head : lists){
            dummy = merge(dummy,head);
        }
        return result.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode curr = new ListNode(-1);
        ListNode result = curr;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l2 != null){
            curr.next = l2;
        }
        if(l1 != null){
            curr.next = l1;
        }
        return result.next;
    }
}
