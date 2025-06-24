/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 // Time Complexity - n*k logk
 // space complexity - O(k)
 // solve don leetcod e- yes
 // faced any issues - No

// In this approach, we are using minHeap(the smallest element will always be at the top). So, initially we are adding all the lists 1st element(smallest of the list) to the Priority Queue. The top most element will be the smallest of all the inserted elements, so we are removing it and adding it to the result. Then we are adding the next element of that list to the queue. Iterate it till the queue becomes empty.Hence returning result. next, because result was pointed to the dummy node -1.
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode current = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head : lists) {
            if(head !=null) {
                minHeap.add(head);
            }
        }

        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;
            current = current.next;
            if(min.next!=null)
            minHeap.add(min.next);
        }
        return result.next;
    }
}
