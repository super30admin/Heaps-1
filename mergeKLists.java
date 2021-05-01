// Time complexity - O(NlogK) where N is the number of nodes in the linked list
// Space complexity - O(k) where k is the size of the lists input

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
        if(lists==null || lists.length==0)
            return null;
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>((a,b) -> (a.val-b.val));
        for(ListNode head : lists)
        {
            if(head!=null)
                pq.add(head);
        }
        ListNode curr=dummy;
        while(!pq.isEmpty())
        {
            ListNode temp=pq.poll();
            curr.next=temp;
            if(temp.next!=null)
                 pq.add(temp.next);
            curr=curr.next;
        }
        return dummy.next;
    }

}
