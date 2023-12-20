// Time Complexity : O(n log k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.PriorityQueue;

public class MergeKSortedArray {
    static class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        for (ListNode li : lists) {
            if (li != null) {
                pq.add(li);
            }
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp.next != null) {
                pq.add(temp.next);
            }
            head.next = temp;
            head = head.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // Example lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // Create an array of lists
        ListNode[] lists = {list1, list2, list3};

        // Create an instance of the Solution class
        MergeKSortedArray solution = new MergeKSortedArray();

        // Call the mergeKLists method
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
