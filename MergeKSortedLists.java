/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Time Complexity: O(N*k) where N is the total number of nodes and k is the number of lists
 * Space Complexity: O(1)
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode first = lists[0];
        ListNode firstHead = first;
        int i = 1;
        while (i < lists.length) {
            first = firstHead;
            ListNode second = lists[i];
            ListNode firstPrev = new ListNode(-10001);

            if (first == null && second != null) { // copy the second half
                firstHead = second;
                return firstHead;
            } else if (first != null && second == null) {
                return firstHead;
            }

            while (first != null && second != null) {

                ListNode firstNext = first.next; // store first next to temp
                ListNode secondNext = second.next; // store second next to temp
                if (first.val > second.val) {

                    if (firstPrev.val == -10001) {
                        ListNode temp = first;
                        first = new ListNode(second.val);
                        first.next = temp;
                        firstHead = first;
                    } else {
                        second.next = first;
                        firstPrev.next = second;
                    }
                    firstPrev = first;
                    first = firstNext;
                    second = secondNext;
                } else if (first.val < second.val) {
                    firstPrev = first;
                    first = first.next;

                } else {
                    first.next = second; // point first to second
                    first = first.next; // move to second
                    first.next = firstNext; // assign first next to stored pointer
                    second = secondNext; // move to second next
                    firstPrev = first;
                    first = first.next; // move to next comparison
                }
            }
            if (first == null && second != null) { // copy the second half
                firstPrev.next = second;
            }
            i++;
        }

        return firstHead;

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
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
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
