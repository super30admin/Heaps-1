package Heaps1;
// Time Complexity : O(N.k^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

import LinkedList1.ListNode;

public class MergeLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for(ListNode l : lists){
            ans = merge(ans, l);
            // System.out.println(ans);
        }
        return ans;

    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;

            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;

        }
        if (l1 != null){
            res.next = l1;
        }

        if (l2 != null){
            res.next = l2;
        }
        return head.next;
    }
}
