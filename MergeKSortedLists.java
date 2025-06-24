// Approach: Use a min-heap (priority queue) to always extract the smallest current node from the heads of all k sorted lists, and build the merged list incrementally.
// Time Complexity: O(N log k) — where N is the total number of nodes across all lists, and k is the number of lists (heap operations are log k per node).
// Space Complexity: O(k) — for storing up to k nodes in the priority queue at any time.
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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(ListNode head : lists)
            if(head != null)
                pq.add(head);
        ListNode ans = new ListNode(-1);
        ListNode curr=ans;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            if(temp.next != null)
                pq.add(temp.next);
            curr = curr.next;
        }
        return ans.next;
    }
}
