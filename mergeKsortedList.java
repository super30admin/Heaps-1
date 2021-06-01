// Time Complexity :O(nk)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


 class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

public class mergeKsortedList {
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged=new ListNode(Integer.MIN_VALUE);
        for(ListNode pointer:lists){
            if(pointer!=null){
                merged=merge(merged,pointer);
            }
            
        }
        
        return merged.next;
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
            
            if(l1!=null){
                curr.next=l1;
            }
            if(l2!=null){
                curr.next=l2;
            }
            
            
        }
        
        return dummy.next;
    }
}
