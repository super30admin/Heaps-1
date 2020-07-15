class Solution {
        // Time Complexity : O(Nk)  N: all list nodes(nk) ; k: no. of lists
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. do merge of two lists and so on untill all are merged.
 */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;

        ListNode result = lists[0];
        for(int i =1; i<lists.length;i++){
            result = merge(result,lists[i]) ;        
        }
        
        return result;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(l1 != null && l2!= null){
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
        if(l1  != null) dummy.next = l1;
        if(l2 != null)  dummy.next = l2;
        return result.next;
    }
}



class Solution {
        // Time Complexity : O(Nk)  N: all list nodes(nk) ; k: no. of lists
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. do merge of two lists and so on untill all are merged.
 */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;

        ListNode result = lists[0];
        for(int i =1; i<lists.length;i++){
            result = merge(result,lists[i]) ;        
        }
        
        return result;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        while(l1 != null && l2!= null){
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
        if(l1  != null) dummy.next = l1;
        if(l2 != null)  dummy.next = l2;
        return result.next;
    }
}



