/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * Time Complexity : O(n) where n is total number of elements in all the lists
 * Space Complexity : O(1)
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode result = merged;
        
        for(ListNode list : lists){
            merged = mergeLists(merged, list);
        }
        
        return result.next;
        
    }
    
    private ListNode mergeLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        while(list1 != null && list2 != null){
            
            if(list1.val < list2.val){
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        
        if(list1 != null){
            dummy.next = list1;
        }
        
        if(list2 != null){
            dummy.next = list2;
        }
        
        return result.next;
    }
}