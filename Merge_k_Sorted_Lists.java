//Time Complexity : O(nk log k)
//Space Complexity : O(nk)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.PriorityQueue;

class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> PQ = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode target = new ListNode(-1);
        ListNode result = target;
        ListNode min = null;
        for(ListNode node : lists)
        {
            PQ.add(node);
        }
        
        while(!PQ.isEmpty())
        {
            min = PQ.poll();
            target.next = min;
            target = target.next;
            if(min.next != null)
                PQ.add(min.next);
        }
        return result.next;
    }
}
