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

//TC:o(nlogn)
//sc:o(n)
class Solution {
    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        
        for(ListNode l : lists )
        {
          while(l!=null) 
          {
            p.add(l.val);
            l=l.next;   
          }
  
        }
        
        ListNode m = new ListNode();
        ListNode current = m;
        while(p.size()!=0)
        {
           current.next = new ListNode(p.remove()); 
           current=current.next ;
            
        }
        
        return m.next;
    }
}