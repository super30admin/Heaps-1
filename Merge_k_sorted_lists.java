import java.util.PriorityQueue;
//Time Complexity : O(nk log k)
//Space Complexity : O(k)

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        //store elements of lists in priorty queue
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        //dummy node
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        //until queue is not empty
        while(!pq.isEmpty()){
            //remove elements one by one
            ListNode min = pq.poll();
            //point current to min
            curr.next = min;
            curr = curr.next;
            //if add in queue until it reaches null
            if(min.next!=null){
                pq.add(min.next);
            }
        }
      return result.next;
    }
}
