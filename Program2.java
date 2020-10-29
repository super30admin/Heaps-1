// Time Complexity: O(N log(N))
// Space Complexity: O(N)
// Passed Leetcode

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
import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for (int i = 0; i < lists.length; i++) {
            
            ListNode head = lists[i];
            while(head != null) {
                minHeap.add(head.val);
                head = head.next;
            }
        }
        
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        int heapSize = minHeap.size();
        for (int i = 0; i < heapSize; i++) {
            ListNode node = new ListNode(minHeap.remove());
            head.next = node;
            head = node;
        }
        return temp.next;
    }
}
