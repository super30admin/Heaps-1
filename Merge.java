TC - O(n log k)
SC - O(k)
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
        PriorityQueue<ListNode> pq = new PriorityQueue(new pqComp());
        for(ListNode list: lists){
            if(list != null)
            pq.add(list);
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(!pq.isEmpty()){
            ListNode top = pq.remove();
            if(top.next != null){
                pq.add(top.next);
            }
            curr.next = top;
            curr = curr.next;
        }
        return head.next;
    }
}
     class pqComp implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2){
            return n1.val - n2.val;
        }
    
}