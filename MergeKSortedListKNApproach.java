/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
Time complexity : O(kN) where k is the number of linked lists.
where N is the total nodes in the result list and k is the number of linked list.
here I am doing k-1 comparisons.

Space complexity would be O(1) as I am not using any auxilary space.
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode merged = null;
        for(int i=0; i< lists.length; i++)
            merged = mergeLists(merged, lists[i]);

        return merged;
    }
    //merging 2 lists
    private ListNode mergeLists(ListNode l1, ListNode l2){
        if(l1 ==null && l2 == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ptr.next = l1;
                l1 =l1.next;
            }
            else{
                ptr.next = l2;
                l2 =l2.next;
            }
            ptr = ptr.next;
        }
        if(l1 != null)
            ptr.next = l1;
        if(l2 != null)
            ptr.next = l2;
        return dummy.next;
    }
}
