// Time Complexity : O(nklogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

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
class mergeKSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) { // add first elements of each list
            if (head != null)
                pq.add(head);
        }
        
        ListNode dummy = new ListNode(-1); //result list
        ListNode curr = dummy; // curr node to traverse through lists
        
        while (!pq.isEmpty()) {
            ListNode min = pq.poll(); //top element will be minimum since we are using minHeap
            curr.next = min; // adding min node to result list
            curr = curr.next; //move curr pointer to new node
            if (min.next != null) // if next of min is null no action required
                pq.add( min.next); // need to add the next of min node to queue
        }
        
        return dummy.next; //next because it's starting from dummy node -1
    }
}
}
