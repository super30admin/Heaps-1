//  Leetcode 23: Merge K sorted arrays
// Time - O(nk^2)
// space - O(n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        
        for(ListNode list: lists){
            merged = merge(merged, list);
        }
        
        return merged.next;
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        
        ListNode head3 = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head3;
        
        while(head1 != null && head2 != null){
            
            if (head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
            }else{
                curr.next = head2;
                head2 = head2.next;
            }
            
            curr = curr.next;
        }
        
        if(head1 != null){
            curr.next = head1;
        }
        
        if(head2 != null){
            curr.next = head2;
        }
        
        return head3.next;
    }
}