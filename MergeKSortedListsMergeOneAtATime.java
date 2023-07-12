public class MergeKSortedListsMergeOneAtATime {


        public ListNode mergeKLists(ListNode[] lists) {

            ListNode merged = new ListNode(Integer.MIN_VALUE);

            for(ListNode li: lists) {

                // update merged from last merged list and current list
                if(li != null)  merged = mergeTwoLL(merged, li);
            }
            return merged.next;
        }

        public ListNode mergeTwoLL(ListNode n1, ListNode n2) {

            ListNode dummy = new ListNode(-1);

            ListNode curr = dummy;

            //pointer on list 1
            ListNode p1 = n1;

            //pointer on list 2
            ListNode p2 = n2;

            while(p1 != null && p2 != null) {

                if(p1.val < p2.val) {

                    // move current to smaller pointer
                    curr.next = p1;

                    // update pointer of list which contributed to current list
                    p1 = p1.next;

                } else {

                    curr.next = p2;

                    p2 = p2.next;
                }

                curr = curr.next;
            }

            // add non-empty list pointer to current and end merging
            if(p1 != null) curr.next = p1;

            if(p2 != null) curr.next = p2;

            return dummy.next;
        }


}

/*
TIME COMPLEXITY = O(nk^2)

SPACE COMPLEXITY = O(1) - only pointers used
*/