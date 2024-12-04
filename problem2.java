import java.util.PriorityQueue;

public class problem2 {
// Time Complexity: nlog(k) , heapify k elements
// Space Complexity: o(k); since the size of heap is maintained to k always
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)-> a.val - b.val);
        for (ListNode l : lists) {
            if (l != null) {
                pq.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode currMin = pq.poll();
            cur.next = currMin;
            cur = cur.next;
            if (currMin.next != null) {
                pq.add(currMin.next);
            }
        }
        return dummy.next;
    }
}
