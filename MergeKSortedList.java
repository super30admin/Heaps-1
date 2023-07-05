import java.util.PriorityQueue;

public class MergeKSortedList {
//TC=O(Nlog(k)) where N=n*k
//SC=O(N) where N=n*k
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b)->a.val-b.val);
        ListNode dummy= new ListNode(-1);
        ListNode curr=dummy;
        for(ListNode list:lists){
            if(list!=null)
                pq.add(list);
        }
        while(!pq.isEmpty()){
            ListNode minimumNode=pq.poll();
            curr.next=minimumNode;
            curr=curr.next;
            if(minimumNode.next!=null){
                pq.add(minimumNode.next);
            }
        }
        return dummy.next;
    }
}
