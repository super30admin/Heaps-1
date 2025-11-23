import java.util.PriorityQueue;
/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Time Complexity: O(N log k) where N is the total number of nodes and k is the number of lists
 * Space Complexity: O(k) for the priority queue
 */
public class MergeKSortedLists1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pg = new PriorityQueue<>((a, b) -> a.val - b.val); // min heap

        for (ListNode node : lists) {
            if (node != null) {
                pg.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        while (!pg.isEmpty()) {
            ListNode smallest = pg.poll();
            dummy.next = smallest;
            dummy = dummy.next;
            if (smallest.next != null) {
                pg.add(smallest.next);
            }
        }

        return first.next;
    }

    public static class ListNode {
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

    public static void main(String[] args) {
        MergeKSortedLists1 mergeKSortedLists = new MergeKSortedLists1();
        ListNode[] lists = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)) };
        ListNode result = mergeKSortedLists.mergeKLists(lists);
        print(result);

        // generate where subsequent list is greater than the first
        // Test case: each subsequent list is longer than the previous and all values
        // are greater than the previous list's max
        ListNode[] testLists = {
                // Length 1
                new ListNode(2),
                // Length 2
                new ListNode(2, new ListNode(3)),
                // Length 3
                new ListNode(3, new ListNode(5, new ListNode(6))),
                // Length 4
                new ListNode(
                        6, new ListNode(
                                8, new ListNode(
                                        9, new ListNode(10))))
        };
        result = mergeKSortedLists.mergeKLists(testLists);
        print(result);

        // [[],[1]]
        // Test case: one empty list and one list with one element
        ListNode[] testLists2 = {
                null,
                new ListNode(1)
        };
        result = mergeKSortedLists.mergeKLists(testLists2);
        print(result);

        ListNode[] testLists3 = { new ListNode(2), new ListNode(0), new ListNode(1) };
        result = mergeKSortedLists.mergeKLists(testLists3);
        print(result);
    }

    private static void print(ListNode testResult) {
        System.out.print("Merged list where subsequent list has greater values and length: ");
        while (testResult != null) {
            System.out.print(testResult.val + " ");
            testResult = testResult.next;
        }
        System.out.println(); // newline after output
    }

}
