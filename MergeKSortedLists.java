//TC: O(m*n log(mn))
//SC: O(m*n)
//approach: minheap

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Node head : lists) {
            while (head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        Node dummyNode = new Node(-1);
        Node head = dummyNode;
        while (!minHeap.isEmpty()) {
            head.next = new Node(minHeap.remove());
            head = head.next;
        }
        return dummyNode.next;
    }

    class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}