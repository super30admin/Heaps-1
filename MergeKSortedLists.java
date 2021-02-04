/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
 */
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(ListNode listNode: lists)
        {
            ListNode temp = listNode;
            
            while( temp != null)
            {
                
                queue.add(temp.val);
                temp = temp.next;
            }
        }
        
        
        ListNode newHead = new ListNode(-1);
        ListNode dummy = newHead;
        
        while(!queue.isEmpty())
        {
            int value = queue.poll();
            ListNode newnode = new ListNode(value);
            newHead.next = newnode;
            newHead = newnode; 
        }
        
        
        return dummy.next;
    }
}