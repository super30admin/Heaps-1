//Time: O(nlogk)
//Space: O(k)

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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);

        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null)
                pq.add(lists[i]);

        ListNode head = pq.poll();
        ListNode itr = head;
        if(head!=null && head.next!=null)
            pq.add(head.next);
        ListNode top;
        while(!pq.isEmpty()){
            top = pq.poll();
            head.next = top;
            head = top;
            if(top.next!=null)
                pq.add(top.next);
            head.next = null;
        }
        return itr;
    }
}