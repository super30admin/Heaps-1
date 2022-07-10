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
    class mycomparator implements Comparator<ListNode>{
        public int compare(ListNode l1,ListNode l2){
            return l1.val-l2.val;
            
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
      //TC O(n log k) n -total elements k =no.of lists , SC:O(n) for queue
        PriorityQueue<ListNode>  pq=new PriorityQueue<>(new mycomparator());
        for(ListNode li:lists){
            if(li!=null)
                pq.add(li);
        }
        ListNode result=new ListNode();
        ListNode curr=result;
        while(!pq.isEmpty()){
            curr.next=pq.poll(); //remove min and connect to curr
            curr=curr.next; //move curr ahead and check if its not null..add to pq
            if(curr.next!=null)
                pq.add(curr.next);
        }
        return result.next;
        
    }
}
