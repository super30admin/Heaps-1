//Time Complexity : O(nlogk)
//Space Complexity : O(n)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists == null || lists.length <=0){
            return null;
        }
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
         PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> l1.val-l2.val);
        
        for(ListNode node: lists){
            if(node!=null)
            pq.add(node);
        }
        
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            if(temp.next!=null){
                pq.add(temp.next);
            }
            curr = temp;
            
        }
        
        return head.next;
    }
}