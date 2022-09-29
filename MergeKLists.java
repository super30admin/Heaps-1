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

/*
    Time Complexity - O(nklog(k)) - ni sthe average number of elements in the lists and k is number of list
    Space Complexity  - O(k)
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode head:lists){
            if(head!=null){
                q.add(head);
            }
        }
        
        ListNode result = new ListNode(-1);
        ListNode current = result;
        while(!q.isEmpty()){
            
            ListNode min = q.poll();
            current.next = min;
            current = current.next;
            if(min.next!=null){
                q.add(min.next);
            }
            
        }
        
        return result.next;
    }
}
