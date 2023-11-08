// Time Complexity : O(nklogk) where k is number of lists inside the array and n is number of element inside the list.
// Space Complexity : O(k) where k is number of lists inside the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for( ListNode node : lists)
        {
            if(node != null)
                pq.add(node);
        }

        ListNode resultNode = dummy;
        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();
            if(temp.next != null)
                pq.add(temp.next);

            resultNode.next = temp;
            resultNode = resultNode.next;
        }

        return dummy.next;
    }
}
