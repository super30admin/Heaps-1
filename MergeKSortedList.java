import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b) -> a.val-b.val);
        ListNode result = new ListNode(-1);
        for(ListNode head:lists){
            if(head!=null)minheap.add(head);
        }

        ListNode curr = result;
        while(!minheap.isEmpty()){
            ListNode min = minheap.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null)minheap.add(min.next);
        }
        return result.next;
    }
}
