// Time Complexity : O(n log k), n -> total no. of nodes
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach:
//  1. Use min heap of size k and add the first node of all lists
//  2. Remove the min node from heap and add its next node back to heap
// 3. Removed nodes are in sorted order and form linked list

import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (a,b) -> a.val - b.val);

        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                System.out.println(lists[i].val);
                heap.add(lists[i]);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode tmp = result;

        while(!heap.isEmpty()) {
            ListNode node = heap.remove();
            if(node.next != null) {
                heap.add(node.next);
            }
            tmp.next = node;
            tmp = tmp.next;
        }
        return result.next;
    }
}
