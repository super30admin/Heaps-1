import java.util.PriorityQueue;
import java.util.Queue;

// TC - O(N logk)
// SC - O(k)

public class MergeKSortedLists {

    public class ListNode {
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

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            ListNode resultListDummyHead = new ListNode(-1);

            for (ListNode head : lists) {
                if (head != null) {
                    minHeap.add(head);
                }
            }

            ListNode currNode = resultListDummyHead;
            while (!minHeap.isEmpty()) {
                ListNode minNode = minHeap.poll();
                currNode.next = minNode;
                currNode = currNode.next;
                if (minNode.next != null) {
                    minHeap.add(minNode.next);
                }
            }

            return resultListDummyHead.next;
        }
    }
}
