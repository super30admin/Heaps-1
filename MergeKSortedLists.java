//Time Complexity: O(nklogk) where k is number of lists and n is number of elements in each list 
//space Complexity : O(1)
// Merged the lists by adding the heads in the Priority queue

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

    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
    public ListNode mergeKLists(ListNode[] lists) {
        
        for(ListNode head:lists){

            if(head!=null){
              pq.add(head);
            }

        }
       
       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;

       while(!pq.isEmpty()){
           ListNode min = pq.poll();
           curr.next= min;
           curr=curr.next;
           if(min.next!=null){
               pq.add(min.next);
           }
       }
       return dummy.next;
    }
}
