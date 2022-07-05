// Time Complexity : O(NlogK)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // we are given en K linkedlist heads
        // we will arrange them in PriorityQueue Min

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            // This is the smallest head
            ListNode node = pq.poll();
            // Attach
            curr.next = node;

            // Move forward
            curr = curr.next;

            if (node.next != null) pq.add(node.next);

        }
        return dummy.next;
    }
}

/*

Divide and Concure
TS = O(NlogK)
SC = O(logk) (stack space)

class Solution {

    private ListNode merge(ListNode h1, ListNode h2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (h1 != null && h2 != null) {

            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }

            curr = curr.next;
        }

        // either h1 or h2 is null
        if(h1 == null) {
            curr.next = h2;
        } else {
            curr.next = h1;
        }

        return dummy.next;
    }

    private ListNode divideAndConcur(ListNode[] lists, int lo, int hi){

        if (hi < lo) return null;

        // only one list
        if (lo == hi) return lists[lo];

        int mid = lo + (hi - lo)/2;

        ListNode left = divideAndConcur(lists, lo, mid);
        ListNode right = divideAndConcur(lists, mid + 1, hi);

        // we have left and right merged
        // Just merge  them and return new head;
        return merge(left, right);

    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        return divideAndConcur(lists, 0, lists.length - 1);
    }
}
 */

/*

Iterative Merging
Time Complexity = O(NK)
Space Complexity = O(1)

    private ListNode merge(ListNode h1, ListNode h2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (h1 != null && h2 != null) {

            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }

            curr = curr.next;
        }

        // either h1 or h2 is null
        if(h1 == null) {
            curr.next = h2;
        } else {
            curr.next = h1;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;

        // Merge the 2 lists and go till the end
        // Merge in Pairs

        for(ListNode head : lists) {

            curr = merge(head, curr);

        }

        return dummy.next;
    }
 */
