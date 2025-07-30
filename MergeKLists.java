// Time Complexity : O(klogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach : add first element of each list to min heap. Remove the min element (heap's top) and add to result list.
/// also add the next node of the popped node to the heap. Repeat until heap is empty. Return result list
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode resHead = new ListNode();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        ListNode ptr = resHead;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            ptr.next = min;
            if(min.next!=null){
                pq.add(min.next);
                min.next = null;
            }
            ptr = min;
        }
        return resHead.next;
    }
}