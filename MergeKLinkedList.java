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
// Time: O(N)
// Space: O(N)
// Ran succesfully on Leetcode: yes

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {//
         // create a dummy head
        ListNode ans =  new ListNode();
        ListNode head = ans;


        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node: lists) { // add all the Nodes to the Priority Queue
            if(node != null)
                pq.add(node);
        }
        if (pq.isEmpty()) return null;

        while(!pq.isEmpty()) { // poll the smallest Node and add to the ans
            ListNode temp = pq.poll();
            if(temp.next != null) pq.add(temp.next);
            ans.next = temp;
            ans = ans.next;
        }
        return head.next;

    }
}