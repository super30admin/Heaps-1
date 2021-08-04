// Time Complexity : o(nlogk)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        ListNode dummy= new ListNode(-1);
        ListNode current=dummy;
        
        for(ListNode node:lists)
        {
            while(node!=null)
            {
                queue.add(node);
                node=node.next;
            }
        }
        
        while(!queue.isEmpty())
        {
           current.next=queue.poll();
            current=current.next;
            current.next=null;
            
        }
        return dummy.next;
    }
}