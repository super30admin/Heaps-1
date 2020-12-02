/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }if()
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists==null || lists.length==0) return null;
         else{
             PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
                 
                 public int compare (ListNode next, ListNode top){
                     return next.val-top.val;
                 }
                     
             });
             ListNode head = new ListNode(0);
             ListNode tail = head;
             for(ListNode l:lists){
                 if(l!=null)
                     pq.add(l);
             }
             while(!pq.isEmpty()){
                 tail.next= pq.poll();
                 tail = tail.next;
                 if(tail.next!=null){
                     pq.add(tail.next);
                 }
             }
             return head.next;
         }
    }
    
}
