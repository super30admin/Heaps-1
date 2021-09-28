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
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for(ListNode head:lists)
//         {
//             while(head != null)
//             {
//                 pq.add(head.val);
//                 head = head.next;
//             }
//         }
//         ListNode dummy = new ListNode(-1);
//         ListNode head = dummy;
//         while(!pq.isEmpty())
//         {
//             head.next = new ListNode(pq.remove());
//             head = head.next;
//         }
        
//         return dummy.next;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode node : lists)
        {
           if(node != null)
           {
               pq.add(node);
           }
        }
        while(!pq.isEmpty())
        {
            ListNode min = pq.poll();
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