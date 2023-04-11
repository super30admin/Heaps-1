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
 /* Use a min heap and push all heads if linked lists first, then pop out the minimum, add its next node*/
 // TC - O(Nlogk) where N=n*k ;k is no of lists , n is avg length of each list
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode head:lists){
            if (head!=null){
            pq.add(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode curmin = pq.poll();
            curr.next = curmin;
            curr = curr.next;
            if(curmin.next != null){
                pq.add(curmin.next);
            }
        }
        return dummy.next;
        
    }
}