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

    //TC = O(nklogk)
    //SC = O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode resultList = new ListNode(-1);
        ListNode cur = resultList;
        for(ListNode head: lists)
        {
            if(head != null)
            {
                pq.add(head);
            }
        }

        while(!pq.isEmpty())
        {
            ListNode curMin = pq.poll();
            cur.next = curMin;
            cur = cur.next;
            if(curMin.next != null)
            {
                pq.add(curMin.next);
            }
        }
        return resultList.next;
    }
}