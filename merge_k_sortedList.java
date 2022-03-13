//Time complexity: -nklogk
//space complexity : o(k)

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
        
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode node : lists)
        {
            if(node != null)
            {
                q.add(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(!q.isEmpty())
        {
            ListNode min = q.poll();
            curr.next = min;
            if(min.next != null)
            {
                q.add(min.next);
            }
            curr = curr.next;
        }
        
        return dummy.next;
        
        
        
    }
}
