class MergeKSortedLists {
  /**
   * 
   * Time Complexity: O(nk logk)
   * 
   * Space Complexity: O(k)
   * 
   * Were you able to solve this on leetcode? Yes
   */
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((w1, w2) -> w1.val - w2.val);
    
    
    for(ListNode node : lists){
        if(node != null)
            pq.add(node);
    }
    
    ListNode head = new ListNode(-1);
    ListNode curr = head;
    while(!pq.isEmpty()) {
        ListNode temp = pq.remove();
        if(temp.next != null)
            pq.add(temp.next);
        curr.next = new ListNode(temp.val);
        curr = curr.next;
    }
    
    return head.next;
}
}