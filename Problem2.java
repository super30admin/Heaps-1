// Time Complexity : O(n log k) where k is the size of the lists array and n is the number of nodes
// Space Complexity : O(k) where k is the size of lists
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        for(ListNode node : lists){
            if(node != null){
                pq.add(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            result.next = curr;
            result = result.next;

            if(curr.next != null){
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}
