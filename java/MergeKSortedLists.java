// Time Complexity : O(nlogk) 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
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
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->(a.val-b.val));
        ListNode dummy = new ListNode(Integer.MIN_VALUE), curr=dummy;

        for(ListNode head : lists){
            if(head!=null){
                queue.add(head);
            }
        }

        while(!queue.isEmpty()){
            ListNode min = queue.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null){
                queue.add(min.next);
            }
        }
        return dummy.next;
    }
}