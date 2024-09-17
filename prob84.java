// S30 Big N Problem #84 {Hard}
// 23. Merge k Sorted Lists
// Time Complexity :O(n*k) where k is the average length of linked list and n is the number of linked lists
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
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
        //edge case
        if(lists==null || lists.length==0) return null;
        ListNode merged=new ListNode(Integer.MIN_VALUE);
        ListNode result=merged;
        for(ListNode list:lists){
            merged=merge(merged,list);
        }
        return result.next;
    }
    
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode result=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                dummy.next=l1;
                l1=l1.next;
            }else{
                dummy.next=l2;
                l2=l2.next;
            }
            dummy=dummy.next;
        }
        if(l2!=null){
            dummy.next=l2;
        }
        
        if(l1!=null){
            dummy.next=l1;
        }
        return result.next; 
    }
}