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
 //tc - 2 list ->o(2n), 3 list o(3n)=> k list o(kn)=> k*kn=> o(k2n)

 class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li : lists)//o(k)
        {
            if(li!=null)
            {
                merged = merge(merged,li);
            }

        }
        return merged.next;
    }
    private ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(head1 !=null && head2 != null)
        {
            if(head1.val < head2.val)
            {
            curr.next = head1;
            head1 = head1.next;
            }
            else
            {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if(head1 != null)
        {
            curr.next = head1;
        }
        if(head2 != null)
        {
            curr.next = head2;
        }
        return dummy.next;
    }
}