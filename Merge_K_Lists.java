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
    //Time O(Nlogk)
    //Space O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        PriorityQueue<ListNode> PQ = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(int i = 0 ; i < lists.length ; i++)
        {
            if(lists[i] != null) PQ.add(lists[i]);
        }
        while(PQ.size() > 0)
        {
            ListNode node = PQ.poll();
            head.next = new ListNode(node.val);
            head = head.next;
            if(node.next != null)
            {
                PQ.add(node.next);
            }
        }
        return dummy.next;
    }
}