// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.PriorityQueue;

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

class Main {

    public static ListNode mergeKLists(ListNode[] lists) {
        // customized priority Queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // add head into the pq
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        // to store the result
        ListNode result = new ListNode(0);
        // maintain current pointer
        ListNode curr = result;

        // while loop till pq is not empty as we are adding all the nodes in the queue
        while (!pq.isEmpty()) {
            // get refrence of the minimum node add it into the result and increase it's
            // pointer
            ListNode min = pq.poll();
            // add min to next of the current
            curr.next = min;
            // update current pointer
            curr = curr.next;
            // if min.next != null add it into the pq
            if (min.next != null) {
                pq.add(min.next);
            }
        }
        return result.next;

    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print("null");
    }
}