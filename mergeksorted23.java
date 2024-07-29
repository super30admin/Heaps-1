// Time Complexity : O(nlogk)
// Space Complexity : O(k), k is the number of lists in the base list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public  int compare(ListNode n1, ListNode n2){
                return Integer.compare(n1.val, n2.val);
            }
        });
        for(ListNode n: lists){
            if(n != null){
                pq.offer(n);
            }

        }
        ListNode head = pq.peek();

        while(!pq.isEmpty()){
            ListNode current = pq.poll();
            if(current.next != null){
                pq.offer(current.next);
            }
            current.next = pq.peek();
        }
        return head;
    }
}