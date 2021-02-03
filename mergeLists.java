/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
Time complexity O(nlogk)
space complexity O(k)
 */
class Solution {
    Queue<ListNode> pq;
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp=new Comparator<ListNode>(){
        @Override
        public int compare(ListNode l1,ListNode l2){
            return l1.val-l2.val;
        }
        };
        pq=new PriorityQueue<ListNode>(cmp);
        if(lists==null ||lists.length==0) return null;
        for(ListNode l:lists){
            if(l!=null){pq.add(l);}
            
        }
            ListNode head=new ListNode(0);
            ListNode prev=head;
        
        while(!pq.isEmpty()){
            prev.next=pq.poll();
            prev=prev.next;
            ListNode next=prev.next;
            if(next!=null)pq.add(next);
            
        }
        return head.next;
    }
}