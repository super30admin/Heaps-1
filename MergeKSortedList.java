/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 O(nk)
 
 (NK)(logn) + (NK)(logn) 
 
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        
        for (int i=0; i<lists.length; i++)
        {
            if (lists[i] != null)
            {
                pq.add(lists[i]);
            }
        }
        
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;
        
        while(!pq.isEmpty())
        {
            ListNode min = pq.remove();
            
            if (min.next != null)
            {
                pq.add(min.next);
            }
            
            tail.next = min;
            tail = min;
        }
        
        return dummyNode.next;
    }
}
