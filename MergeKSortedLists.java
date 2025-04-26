import java.util.PriorityQueue;
// Time Complexity: O(N log K) where N is the total number of nodes across all lists and K is the number of linked lists.
// Space Complexity: O(K) for the priority queue storing the head nodes of each list.
// LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Merges k sorted linked lists into one sorted linked list using a min-heap.
 * Continuously extracts the smallest node and adds the next node from that list.
 * Time complexity is O(N log K) and space complexity is O(K).
 */

public class MergeKSortedLists {

    //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val) - (b.val));

        for(ListNode first : lists) {
            if(first != null){
                pq.offer(first);
            }
        }

        while(!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null) {
                pq.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
}
