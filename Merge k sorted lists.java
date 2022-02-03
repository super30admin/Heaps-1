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
//Time complexity: O(nk logk)
//Space complexity: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode head: lists)
        {
            if(head!=null)
            pq.add(head);
        }
        
ListNode dummy= new ListNode(-1);
        ListNode curr=dummy;
        
        while(!pq.isEmpty())
        {
            ListNode n= pq.remove();//logk for heapification each time. It does that for nk elements
            curr.next=n;
            curr=n;
            if(n.next!=null)
            pq.add(n.next);
        }
      return dummy.next;  
    }
    
}