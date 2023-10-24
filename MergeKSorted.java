//TC will be O(N log K)
//SC will be O(K)

import java.util.PriorityQueue;

//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            result.next = curr;
            result = result.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        MergeKSorted obj = new MergeKSorted();

        // Create example sorted linked lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Put the linked lists into an array
        ListNode[] lists = {list1, list2, list3};

        // Merge the sorted linked lists
        ListNode mergedList = obj.mergeKLists(lists);

        // Print the merged list (you can replace this with other operations you want to perform)
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}