// Time Complexity : O(n Log k), where n is the number of linked lists and k - nodes
// Space Complexity : O(nK) - storing n * nodes in linked list. If it is just references then O(n)
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/663778470/)
// Any problem you faced while coding this : No
// My Notes : Store the min head of each and move to the next node

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
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode[] ptr = new ListNode[lists.length];
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x,y)->x.val-y.val);
        // Adding the listnode reference
        for(ListNode list : lists){
            if(list!=null){
                pq.offer(list);
            }
        }
        // Till the queue is not empty
        while(!pq.isEmpty()){
            // get the min head val
            // if the head has value, remove and move to next node
            ListNode head = pq.poll();
            if(head!=null){
                result.next = new ListNode(head.val);
            }
            // Move head and result
            result = result.next;
            head = head.next;
            // add head if not null
            if(head!=null){
                pq.offer(head);
            }
        }
        return dummy.next;
    }
}