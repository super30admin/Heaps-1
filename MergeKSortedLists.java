import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Time Complexity : O(nklogk)
//space complexity : O(1)
public class MergeKSortedLists {
    static  class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            if(node != null){pq.add(node);}
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next !=  null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
    public static void main(String args[]){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(7);

        ListNode[] lists = new ListNode[]{head1,head2};
        ListNode result = mergeKLists(lists);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
        
    }
}