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
        if(lists.length==0) return null;
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
            minheap.add(lists[i]);
        }
        ListNode res=new ListNode(-1);
        ListNode curr=res;
        while(!minheap.isEmpty()){
            curr.next=minheap.poll();
            curr=curr.next;
            if(curr.next!=null)
            minheap.add(curr.next);
        }
        return res.next;
    }
}
