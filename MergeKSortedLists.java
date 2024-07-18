import java.util.PriorityQueue;
//time - O(nk log k) n is the number of lists and k is the avg listnodes in each list
//space - O(n)
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(ListNode node : lists) {
            if(node != null) {
                pq.add(node);
            }
        }

        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next != null) {
                pq.add(temp.next);
            }
        }

        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

}
