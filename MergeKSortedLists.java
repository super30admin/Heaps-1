// Time Complexity = O(Nlog(k)), where N= n*k . where n is the no. of elements in each list, and k is the no. of lists.
// Space complexity = O(k)
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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        // heads of the list are added.
        for(ListNode head: lists) {
            if(head!=null) {
                pq.add(head);    
            }
            
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr =dummy;
        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();// min node
            curr.next = minNode;
            
            if(minNode.next!=null) {
                pq.add(minNode.next);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}