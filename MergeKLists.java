import java.util.PriorityQueue;

/**
 * @author Vishal Puri
 * // Time Complexity : O(nk)
 * // Space Complexity : O(k)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }
        if (pq.size() == 0) return null;
        ListNode dummy = pq.poll();
        ListNode curr = dummy;
        if (dummy.next != null)
            pq.add(dummy.next);
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null)
                pq.add(temp.next);
        }
        return dummy;
    }
}
