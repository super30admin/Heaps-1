// The time complexity of this implementation is O(Nlog K) where
// N is number of nodes and K is number of lists

import java.util.PriorityQueue;

public class MergedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        MergedLinkedLists solution = new MergedLinkedLists();
        ListNode mergedList = solution.mergeKLists(lists);


        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
