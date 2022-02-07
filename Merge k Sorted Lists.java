// # Time Complexity :
// # TC: O(nklogk)

// # Space Complexity :
// # SC: O(k)

// # Did this code successfully run on Leetcode :
// # Yes

// # Any problem you faced while coding this :
// # No

// # Your code here along with comments explaining your approach


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
class Solution {
    
    // Heap Solution -> storing only one node of each LL in heap
    // TC: O(nklogk)
    // SC: O(k)
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        // Making Priority Queue to hold list nodes depending upon the list nodes values
        PriorityQueue<ListNode>  pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode head: lists){
            if (head != null) pq.add(head);
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null){
                pq.add(minNode.next);
            }
        }
        
        return dummyHead.next;
    }
}