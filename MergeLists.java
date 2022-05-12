import java.util.PriorityQueue;

public class MergeLists {

    // Using Min heap
    // TC : O(nk * log nk) k - number of lists  n - max length of a linked list
    // SC : O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        // First add the first node of each list element into the queue
        // We are putting the node at base address of each list in lists
        for(ListNode head : lists) {
            if(head != null) // This will handle input like [[]]
                queue.add(head);
        }

        while(!queue.isEmpty()) {
            ListNode min = queue.poll();
            current.next = min;
            current = current.next;

            if(min.next != null)
                queue.add(min.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeLists m = new MergeLists();
        m.mergeKLists(new ListNode[]{
            null
        });
    }
}


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
