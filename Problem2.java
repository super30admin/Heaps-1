//Time Complexity : O(Nklog(k))
// Space Complexity : O(k), for the heap
// Did this code successfully run on Leetcode : Yes
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

//using min heap to get minimum at the top and removing it

class Problem2 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head : lists){

            if(head !=null){
                q.add(head);

            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!q.isEmpty()){

            ListNode min = q.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                q.add(min.next);
            }

        }

        return result.next;
    }
}