import java.util.PriorityQueue;
//SC O(k) where k is the size of list
//TC O(Nlog(k)) where N is the number of nodes in list and k is the size of the list
public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (ListNode list : lists) {
            if (list!=null)
                queue.add(list);
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
                current.next = node;
                if (node.next!=null){
                    node = node.next;
                    queue.add(node);
                }
                current = current.next;
            }

        return dummy.next;
    }
}
