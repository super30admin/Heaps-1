/**
//Accepted on LT 
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
        for(ListNode l : lists){
            if(l!=null){
                pq.add(l);
            }
        }
        ListNode dum = new ListNode(-1);
        ListNode cr = dum;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            cr.next = min;
            cr=cr.next;
            if(min.next!=null){
                pq.add(min.next);
            }
            
        }

           
        return dum.next;
        
    }
}