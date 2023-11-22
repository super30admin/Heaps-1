// TC : O(k*logk + kn*logk)
// SC : O(k)

package S30_Codes.Heaps_1;
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }

        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            curr.next = node;
            curr = curr.next;
            if(node.next != null)
                pq.add(node.next);
        }

        return dummyHead.next;
    }
}