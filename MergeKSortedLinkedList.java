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
 //Create a Min heap of Nodes 
 //Time complexity: N log k
 //Space complexity:O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode mergedHead = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b)->a.val-b.val
        );

        for(ListNode head :lists){
            if(head!=null)
                pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            if(temp.next != null)
                pq.add(temp.next);
            result.next = temp;
            result = result.next;
        }
        return mergedHead.next;
    }
}

