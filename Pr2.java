//Time Complexity: O(nklogk) n- average size of each list k - no of lists
//Space Complexity: O(k)

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
          PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head: lists){
            if(head != null){
                pq.add(head);
            }            
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.remove();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next != null){
                pq.add(minNode.next);
            }
        }

        return dummy.next;

    }
    
}