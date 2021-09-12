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
        ListNode merged = new ListNode();
        //Base 
        if(lists==null || lists.length == 0){
            return null; //merged
        }
        
        //Algorithm
        //Since PriorityQueue is of type ListNode , we need 
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head: lists){
            if(head!=null){
                pq.add(head);
            }
        }
        //Init root or new head pointer for Linked list
        //Start constructing the list
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(!pq.isEmpty()){
            ListNode minElement =  pq.poll();
            curr.next = minElement;
            curr = curr.next;
            minElement = minElement.next;
            if(minElement!=null){
                pq.add(minElement);
            }
        }
        return head.next;   
    }
}
