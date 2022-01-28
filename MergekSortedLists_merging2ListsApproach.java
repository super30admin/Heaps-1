//Time: O(nk^2)
//Space: O(1)
//Leetcode: https://leetcode.com/submissions/detail/628989924/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE); //dummy list
        for(ListNode head: lists) {
            merged = merge(merged, head);
        }
        return merged.next;
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        //no need to iterate, just attach the remaining list
        if(head1 != null){
            curr.next = head1;
        } 
        if(head2 != null) {
            curr.next = head2;
        }
        return dummy.next;
    }
}