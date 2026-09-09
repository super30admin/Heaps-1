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
//Time Complexity: O(Nlogk)
//Space Complexity: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        //Add root nodes into the Min Heap
        for(ListNode head: lists)
        {
            if(head != null)
            {
                pq.add(head);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode min = pq.poll(); //Removes minimum node
            curr.next = min;
            curr = curr.next;
            if(min.next != null)
            {
                pq.add(min.next);
            }
        }

        return dummy.next;
    }
}