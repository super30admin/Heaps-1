import java.util.*;

class Solution {
    // Solution using min heap
    // Time complexity is O(nlogk)
    // Space complexity is O(k) priority queue space
    // This solution is submitted on leetcode with zero errors
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if(lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode li : lists){
            // Just putting heads inside pq
            if(li !=null)
                pq.add(li);
        }
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        return result.next;
    }
}