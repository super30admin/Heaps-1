//using heap sort(min heap)
//TC: O(nk logk) ,n-> avg no. of elements inside list 
//SC:O(k)

class Solution {
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

// Merge Sort
// TC:O(nk^2) //for merging 2 lists -> 2n time ; for 3 lists 3n => 2n+3+4n...kn
// and we have k lists ; so nk^2
// SC: O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE); // taking first list as -infinty beacuse there may be
                                                           // negative values as well
        for (ListNode li : lists) {
            if (li != null) {
                merged = merge(li, merged); // calling merge function
            }
        }
        return merged.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) { // comapring values and then connecting it to the new list
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            } else {
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        if (head1 != null) { // if there are elements left in list1
            curr.next = head1;
            curr = curr.next;
        }
        if (head2 != null) { // if there are elements left in list2
            curr.next = head2;
            curr = curr.next;
        }
        return dummy.next;
    }
}
