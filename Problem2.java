/**
 * Time Complexity: O(N log k)
 *  Space Complexity: O(1)
 */

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
        
        if(lists.length==0 || lists == null)
            return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((t1,t2) -> t1.val-t2.val);
        
        ListNode dummy = new ListNode(0);
        
        ListNode curr = dummy;
        
        //add first k header
        for(ListNode node: lists)
        {
            if(node!=null)
                pq.add(node);
            
        }
        
        while(!pq.isEmpty())
        {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next!=null)
            {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}