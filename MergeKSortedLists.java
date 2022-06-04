// Time Complexity :O(Nk.Logk), k= #Lists, N=avg  listt size
// Space Complexity :O(k) for heap, ignoring the output list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(ListNode head : lists) {
            if(head != null) {
                heap.add(head);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!heap.isEmpty()) {
            ListNode min = heap.poll();
            curr.next  = min;
            curr = curr.next;
            if(min.next != null)
                heap.add(min.next);
        }
        return result.next;
    }
}
