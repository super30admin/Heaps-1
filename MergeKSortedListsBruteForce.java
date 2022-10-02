// Time complexity: O(nk^2) where n is the avg number of nodes in each list, k is the number of lists, and when we are merging two lists, the list size becomes double, so the next time we merge it keeps increasing. Hence it is k^2

// Space complexity: O(1)

// Approach: brute force We just use merge 2 sorted lists algorithms from another problem and we do that for all lists

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        ListNode curr = merged;
        for(ListNode list : lists) {
            if (list != null) {
                curr = merge2Lists(curr, list);
            }
        }
        return merged.next;
    }
    
    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            }
            else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;
        
        return result.next;
    }
}