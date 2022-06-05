TC: O(nklogk) n is size of the max length list and k is the no.of linkedlists in the inputs list
SC: O(K) for priority queue
Successfully run in leetcode: yes

//Used a min heap and pushed alll the heads of the linkedlists into the priority queuue. Unitil the queue 
//becomes empty pop the node(minimum node) from the queue and link it to the result. if the next val
of the popped min node exists push that to the queue and continue this until queue becomes empty.





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
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head : lists){
            if(head!=null) pq.add(head);
        }
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            cur.next = min;
            cur=cur.next;
            if(min.next!=null) pq.add(min.next);
           
        }
        return result.next;
    }
}