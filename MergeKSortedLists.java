public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


// Time Complexity : O(nk^2) where n is the number of elements in each list & k is the number of lists
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1: Brute Force

    class BruteForceSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode merged = new ListNode(Integer.MIN_VALUE);
            for (ListNode li : lists) {
                if (li != null) {
                    merged = merge(merged, li);
                }
            }
            return merged.next;
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    curr.next = head1;
                    head1 = head1.next;
                } else {
                    curr.next = head2;
                    head2 = head2.next;
                }
                curr = curr.next;
            }

            if (head1 != null) {
                curr.next = head1;
            }

            if (head2 != null) {
                curr.next = head2;
            }
            return dummy.next;
        }
    }

// Time Complexity : O(nk logk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 2: Using min heap

    class MinHeapSolution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode head : lists) {
                if (head != null) {
                    pq.add(head);
                }
            }

            ListNode result = new ListNode(-1);
            ListNode curr = result;

            while (!pq.isEmpty()) {
                ListNode min = pq.poll();
                curr.next = min;
                curr = curr.next;

                if (min.next != null) {
                    pq.add(min.next);
                }
            }
            return result.next;
        }
    }
}