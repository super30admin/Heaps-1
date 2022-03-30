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

    //TC: O(n log n)

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a,b)-> a.val -b.val);


        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        // adding only head nodes to pq
        for(int i = 0 ; i < lists.length ; ++i)
        {
            if(lists[i] != null)
            {
                pq.add(lists[i]);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode minNode = pq.remove(); //k => logk
            if(minNode.next != null)
            {
                pq.add(minNode.next);
            }
            tail.next = minNode;
            tail = minNode;
        }
        return dummyHead.next;

    }
}