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
            merged = merge(merged, li);
        }
        return merged.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1); 
        ListNode result = dummy;
        while(l1 != null && l2 !=null){
            if(l1.val<l2.val){
                dummy.next= l1;
                    l1 = l1.next;
            }
            else{
                dummy.next= l2;
                l2=l2.next;
            }
            dummy= dummy.next;
        }
        if(l2 != null){
            dummy.next = l2;
        }
        if(l1!= null){
            dummy.next = l1;
        }
        return result.next;
        }
}