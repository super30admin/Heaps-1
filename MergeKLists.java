// Time Complexity : O(n log k) where n - total # of nodes and k - # of lists
// Space Complexity : O(k) where heap size is restricted to # of lists heads
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


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
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode list:lists){
            if(list != null)
                heap.add(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!heap.isEmpty()){
            ListNode top = heap.poll();
            curr.next = top;
            curr = curr.next;
            if(top.next != null)
                heap.add(top.next);
        }
        return dummy.next;
    }
}
