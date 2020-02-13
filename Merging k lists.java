// Time complexity - 0(kn) - k lists
// space complexity - 0(n)
// code successfully executed on leetcode
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode result = merged;
        for(ListNode list:lists){
            merged = merger(merged,list);  
        }
        return result.next;
        
    }
    private ListNode merger(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                dummy.next =l1;
                l1 =   l1.next;
            } else {
                dummy.next =l2;
                l2 =   l2.next;
            }
            dummy = dummy.next;
        }
        if(l2!=null){
            dummy.next = l2;
        }
        if(l1!=null){
            dummy.next = l1;
        }
        return result;
    }
}
        