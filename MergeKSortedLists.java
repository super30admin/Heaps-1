//Space complexity O(k) for storing k elements in Q
// Time complexity O(nlogk) where n is the combined number of elements in all the linkedlists and k is the number of linkedlists to merge
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
       PriorityQueue<ListNode> q = new PriorityQueue<>((a,b)->a.val-b.val) ;
       ListNode res = new ListNode();
       ListNode curr= res;
       for(ListNode h :lists)
       {
           if(h!=null)
               q.add(h);
       }
        while(!q.isEmpty())
        {
            ListNode val = q.poll();
            if(val.next!=null)
                q.add(val.next);
            curr.next= val;
            curr= val;
        }
        return res.next;
            
        
    }
}