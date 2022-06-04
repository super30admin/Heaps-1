/**

Time complexity: O(nk logk)
Space complexity: O(k)

 */
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
        PriorityQueue<ListNode> p=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists)
        {
            if(head!=null)
                p.add(head);
        }
        ListNode res = new ListNode();
        ListNode curr = res;
        while(!p.isEmpty()){
            ListNode node=p.poll();
            if(node.next!=null)
                p.add(node.next);
            curr.next=node;
            curr=curr.next;
            
        }
        return res.next;
    }
}