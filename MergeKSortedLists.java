import java.util.PriorityQueue;

public class MergeKSortedLists {

    // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    // Brute Force
    // TC: O(nk^2) where n is the number of elements in each list & k is the number of lists
    // SC: O(nk)

    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode merged = new ListNode(Integer.MIN_VALUE);
            for(ListNode li: lists){
                if(li != null){
                    merged = merge(merged,li);
                }
            }
            return merged.next;
        }

        private ListNode merge(ListNode head1 , ListNode head2){
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;

            while(head1 != null && head2 != null){
                if(head1.val < head2.val){
                    curr.next = head1;
                    head1 = head1.next;
                }
                else{
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
            return dummy.next;
        }
    }

    // Using MinHeap
    // TC: O( nk log k) where n is the number of elements in each list & k is the number of lists
    // SC: O(k)

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for(ListNode head: lists){
                if(head != null) {
                    pq.add(head);
                }
            }

            ListNode result = new ListNode(-1);
            ListNode curr = result;

            while(!pq.isEmpty()){
                ListNode min = pq.poll();
                curr.next = min;
                curr = curr.next;

                if(min.next != null){
                    pq.add(min.next);
                }
            }
            return result.next;
        }
    }
}
