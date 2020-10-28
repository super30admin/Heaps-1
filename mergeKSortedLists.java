/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 Time Complexity: O(nlogk)
 Space Complexity: O(1)
 */


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
        {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((t1,t2)-> t1.val-t2.val);

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for(ListNode header : lists)
        {
            if(header != null)
            {
                queue.add(header);
            }

        }

        while(!queue.isEmpty())
        {
            current.next = queue.poll();
            current = current.next;
            if(current.next!=null)
            {
                queue.add(current.next);
            }
        }

        return dummy.next;
    }
}
