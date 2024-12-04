// Time Complexity :O(n log k)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing
import java.util.PriorityQueue;

public class MergeKlists {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode list: lists){
            if(list != null){
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode currMin = pq.poll();
            curr.next = currMin;
            curr = curr.next;
            if(currMin.next != null){
                pq.add(currMin.next);
            }
        }

        return dummy.next;
    }
}
