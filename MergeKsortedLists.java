//Time Complexity : O(nklogk) n = length of nums
//Space Complexity : O(k)

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

//using heap

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        //add all heads to pq
        for(ListNode head : lists)
        {
            if(head != null)
                pq.add(head);
        }

         //dummy head of resultant list
        ListNode result = new ListNode(-1);
        ListNode current = result;

        while(!pq.isEmpty())
        {
            //take out the min
            ListNode min = pq.poll();
            //add min to result
            current.next = min;
            //move the current to next in the result list
            current = current.next;
            //add the next of min list into queue
            if(min.next != null)
                pq.add(min.next);
        }

        return result.next;
    }
}
