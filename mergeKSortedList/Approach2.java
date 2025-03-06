package mergeKSortedList;

//tc:NlogK
//k is the no of lists
//sc: O(k)

class Approach2 {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode merged = new ListNode(Integer.MIN_VALUE);

        for(ListNode li : lists) {
            if(li == null) {
                continue;
            }

            merged = merge(merged, li);
        }

        return merged.next;
    }

    private  ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }

            curr = curr.next;
        }

        if(p2 != null) {
            curr.next = p2;
        }

        if(p1 != null) {
            curr.next = p1;
        }

        return dummy.next;
    }
}