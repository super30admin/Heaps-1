// Time Complexity : O(N logk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//All all the elements from all the lists to a priority queue
//Pop all the elements from heap one by one and add to new list
//This list will have the merged sorted list
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
        ListNode res = new ListNode();
        ListNode res1 = res;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode x: lists){
            while(x != null){
                pq.add(x.val);
                x = x.next;
            }
        }
        while(!pq.isEmpty()){
            ListNode x = new ListNode(pq.poll());
            res.next = x;
            res = res.next;
        }
        return res1.next;
    }
}