// Time Complexity : Nlogk
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

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
/* // solution is NK TC
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode li: lists){
            merged = merge(li,merged);
        }
        return merged.next;
    }
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                curr.next = h1;
                h1 = h1.next;
            } else{
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if(h2 != null){
            curr.next = h2;
        }
        if(h1 != null){
            curr.next = h1;
        }
        return result.next;
    }
}
*/

//NlogK
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next; //coz we are keeping the next element of the min value node
            if(min.next != null){
                pq.add(min.next);
            }
        }
        return result.next;
    }
}
