
//T.C :O(nlogk)
//S.C : O(k)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.PriorityQueue;

public class Problem2 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val-b.val));
        ListNode dummy  = new ListNode(-1);
        ListNode result = dummy;

        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
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
