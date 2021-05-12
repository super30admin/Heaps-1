// Time Complexity : O(nk logk)
// Space Complexity : O(k)

// Your code here along with comments explaining your approach: 

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null)
      return null;

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    ListNode result = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    for (ListNode l : lists) {
      if (l != null)
        pq.add(l);
    }

    while (!pq.isEmpty()) {
      ListNode cur = pq.remove();
      dummy.next = cur;
      dummy = dummy.next;
      if (cur.next != null)
        pq.add(cur.next);
    }
    return result.next;
  }

}