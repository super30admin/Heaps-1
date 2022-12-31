
import java.util.*;
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists){
            while (list != null){
                pq.offer(list.val);
                list = list.next;
            }
        }
        ListNode head = new ListNode(-1); 
        ListNode temp = head;
        while (!pq.isEmpty()){
            head.next = new ListNode(pq.poll());
            head = head.next;
       }
        return temp.next;
    }
}