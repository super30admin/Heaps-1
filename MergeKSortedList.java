import java.util.PriorityQueue;
/*
Time Complexity : O(n.logk), where k is number of lists and n is average size of lists, log k for insertion
Space Complexity : O(k), one listnode from each K lists will be in the heap
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
We can maintain a priority queue to get the minimum value from k lists. At first, add the k list nodes, pop the minimum out,
add to the result. Check if the popped list node has next value, push it to the priority queue to put in sorted order.
*/
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode result = null;
        if (lists.length == 0) {
            return result;
        }
        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            pq.add(listNode);
        }
        result = new ListNode();
        ListNode head = result;

        while (!pq.isEmpty()) {
            ListNode currentTop = pq.poll();
            result.next = currentTop;
            result = result.next;
            if (currentTop.next != null) {
                pq.add(currentTop.next);
            }
        }
        return head.next;
    }
}
