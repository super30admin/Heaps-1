// Time Complexity : O(nk log(k)) k = num of lists
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
public class MergeLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        //queue as a way to sort lists while going through them
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        //sort the list heads by putting them in the queue
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        //add nodes to result as they come out of queue
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}