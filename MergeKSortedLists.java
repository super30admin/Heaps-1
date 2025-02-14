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
   //Time Complexity: O(nklogk)
   //Space Complexity: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length ==0){
            return null;
        }

ListNode front = new ListNode(-1); 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);  
        for (ListNode node : lists){
            if (node!= null)
            pq.add(node);
        }
    ListNode res = front;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
           front.next = node;
           front = front.next;
           if (node.next != null) 
            pq.add(node.next);
        }
    return res.next;
    }
}
