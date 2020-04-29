// 23.
//time - O(nlogk)
//space - O(k)
//approach - initially have all the heads of each list in pq, then poll to get min and then add the next of polled node

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
        //edge
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode head = dummy;
        
        PriorityQueue<ListNode> support = new PriorityQueue<>((t1, t2) -> t1.val - t2.val); //min heap with custom comparator
        for(ListNode heads : lists)
        {
            if(heads != null) //to handle edge - [[]]
            {
                support.offer(heads); //add only the heads of each list to pq
            }
        }
        
        while(!support.isEmpty())
        {
            ListNode current = support.poll(); //get the min head among all heads
            if(current.next != null)
            {
                support.offer(current.next); //add the next of extracted head into pq
            }
            head.next = current;
            head = current;
        }
        
        return dummy.next;
    }
}
